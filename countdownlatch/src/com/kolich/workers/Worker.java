package com.kolich.workers;

import java.util.Random;

import javax.swing.JProgressBar;

import com.kolich.gui.ThreadingFrame;
import com.kolich.threading.BaseWorker;

public class Worker extends BaseWorker {
	
	private int index_;
	private JProgressBar myProgress_;
	private ThreadingFrame frame_;
	
	public Worker(int progressBarIndex) {
		super();
		index_ = progressBarIndex;
		frame_ = ThreadingFrame.getDefaultInstance();
		myProgress_ = frame_.getProgress(index_);
		if(myProgress_ == null) {
			throw new Error("No JProgressBar found in " +
					"frame for index: " + index_);
		}
	}

	@Override
	public void myRun() throws Exception {
		myProgress_.setValue(0);
		myProgress_.setStringPainted(true);
		myProgress_.setString(getWorkerName());
		for(int i = 1; i <= 10; i++) {
			Thread.sleep(getRandomSleep());
			myProgress_.setValue(i);
		}
		myProgress_.setString(String.format("%s - FINISHED!",
				getWorkerName()));
	}

	@Override
	public String getWorkerName() {
		return String.format("%s #%s",
				getClass().getSimpleName(), index_);
	}
	
	public static final long getRandomSleep() {
		return (new Random().nextInt(3) * 1000L);
	}
	
}
