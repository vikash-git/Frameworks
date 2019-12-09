package com.framework;

import java.awt.EventQueue;
import javax.swing.JFrame;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.UIManager;



public class UI {
	private JFrame frame;
	JTextArea pathDisp;
	static String path=new String();
	/**
	 * Launch the application.
	 */
	public static void main (String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI window = new UI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 352);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 0, 0);
		frame.getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JButton btnSave = new JButton("Save N Exit");
		btnSave.setBounds(189, 269, 117, 23);
		frame.getContentPane().add(btnSave);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.setBounds(31, 38, 89, 23);
		frame.getContentPane().add(btnBrowse);
		
		 pathDisp = new JTextArea();
		 pathDisp.setBackground(UIManager.getColor("Button.background"));
		 pathDisp.setWrapStyleWord(true);
		 pathDisp.setLineWrap(true);
		 pathDisp.setEditable(false);
		pathDisp.setBounds(187, 21, 261, 113);
		frame.getContentPane().add(pathDisp);
		
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(31, 269, 89, 23);
		frame.getContentPane().add(btnStart);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(31, 150, 89, 23);
		frame.getContentPane().add(btnRefresh);
		
		btnBrowse.addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent e)
			{	
				
				 path=Utill.browseBtn();	
				//pathDisp.setText(FileChooser1.open());
				pathDisp.setText(path);
				
			}
		}
				);
		btnStart.addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent e)
			{	
				
				
			try {
				Base.start();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
				
			}
		}
				);
		
		btnRefresh.addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent e)
			{	
				String args[]=null;
				Floating.main(args);
				
			
				
				
			}
		}
				);
		
		
		btnSave.addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent e)
			{	
				
				try {
					Utill.saveDoc();
					System.exit(0);
				} catch (IOException | InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				
				
			}
		}
				);
		
		
		
		
	}
}