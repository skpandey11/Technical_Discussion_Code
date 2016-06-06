package com.kolich;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import com.kolich.gui.ThreadingFrame;
import com.kolich.threading.BaseWorker;
import com.kolich.threading.ThreadRunner;
import com.kolich.workers.Worker;

public class Main {
	
	private static final List<BaseWorker> workers__;
	static {
		workers__ = new ArrayList<BaseWorker>();
		workers__.add(new Worker(0));
		workers__.add(new Worker(1));
		workers__.add(new Worker(2));
		workers__.add(new Worker(3));
		workers__.add(new Worker(4));
	}

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(
				ThreadingFrame.getDefaultInstance());
		
		final ThreadRunner tr = new ThreadRunner(workers__);
		tr.start();
		tr.await();
		
		// Check that all workers in the thread runner
		// finished successfully.  A thread wouldn't
		// have finished successfully if it encountered
		// some type of error or exception condition.
		if(tr.wasSuccessful()) {
			JOptionPane.showMessageDialog(ThreadingFrame.getDefaultInstance(),
				    "All worker threads finished successfully.", "Done",
				    JOptionPane.INFORMATION_MESSAGE);
		}
		
		System.exit(0);
		
	}
	
}
