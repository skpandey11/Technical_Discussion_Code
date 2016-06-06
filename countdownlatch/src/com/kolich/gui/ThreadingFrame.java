package com.kolich.gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

public class ThreadingFrame extends JFrame implements Runnable {

	private static final long serialVersionUID = -7495596548323047514L;
	
	private static final String APP_NAME = "Mark's CountDownLatch Demo";
	
	private List<JProgressBar> bars_;
	
	private static ThreadingFrame theInstance_ = null;
	public synchronized static ThreadingFrame getDefaultInstance() {
		if (theInstance_ == null) {
			theInstance_ = new ThreadingFrame();
		}
		return theInstance_;
	}
	
	private ThreadingFrame() {
		
		super(APP_NAME);
		
		bars_ = new ArrayList<JProgressBar>();
		bars_.add(new JProgressBar(0, 10));
		bars_.add(new JProgressBar(0, 10));
		bars_.add(new JProgressBar(0, 10));
		bars_.add(new JProgressBar(0, 10));
		bars_.add(new JProgressBar(0, 10));
		
		final ThreadingPanel viewPort = new ThreadingPanel();
		viewPort.setPreferredSize(new Dimension(500, 500));
		viewPort.setBorder(new EmptyBorder(0, 0, 0, 0));
		viewPort.setLayout(new GridLayout(bars_.size(), 1));
		getContentPane().add(viewPort);
		
		setContentPane(viewPort);
		
		for(final JProgressBar pb : bars_) {
			final ThreadingPanel pbp = new ThreadingPanel();
			pbp.setBorder(new EmptyBorder(5, 5, 5, 5));
			pbp.setLayout(new GridLayout(1, 1));
			pbp.add(pb);
			viewPort.add(pbp);
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
	}

	@Override
	public void run() {
		
		pack();
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		
		setVisible(true);
		
	}
	
	public JProgressBar getProgress(int index) {
		return bars_.get(index);
	}
	
}
