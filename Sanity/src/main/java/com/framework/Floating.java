package com.framework;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.UIManager;

import com.framework.Floating.FrameDragListener;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.DropMode;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.EtchedBorder;



public class Floating {
	private JFrame frame;
	JTextArea pathDisp;
	public static JTextArea txtrNoOfPrints;
	static String path=new String();
	/**
	 * Launch the application.
	 */
	public static void main (String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Floating window = new Floating();
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Floating() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		final JFrame frame = new JFrame("Hello");

        frame.setUndecorated(true);
        frame.setBounds(0, 0, 100, 100);

        JPanel contentPane = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Drag");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(label.getFont().deriveFont(10f));
        contentPane.add(label, BorderLayout.NORTH);
        frame.setContentPane(contentPane);
        
        
        txtrNoOfPrints = new JTextArea();
        txtrNoOfPrints.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txtrNoOfPrints.setEditable(false);
        txtrNoOfPrints.setWrapStyleWord(true);
        txtrNoOfPrints.setText("No. of prints taken : "+Utill.imgCount+" \r\nNo. of text captured : " +Utill.textCount+"    ");
        txtrNoOfPrints.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        contentPane.add(txtrNoOfPrints, BorderLayout.WEST);
       //  frame.setContentPane(contentPane);
        

        FrameDragListener frameDragListener = new FrameDragListener(frame);
        frame.addMouseListener(frameDragListener);
        frame.addMouseMotionListener(frameDragListener);
        frame.setAlwaysOnTop(true);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
       
        int delay = 1000; //milliseconds
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) 
            {
            	 txtrNoOfPrints.setText("No. of prints taken : "+Utill.imgCount+" \r\nNo. of text captured : " +Utill.textCount+"    ");
            	
            	
            }
        };
        new Timer(delay, taskPerformer).start();
		
		
		
	}
	 public static class FrameDragListener extends MouseAdapter {

	        private final JFrame frame;
	        private Point mouseDownCompCoords = null;

	        public FrameDragListener(JFrame frame) {
	            this.frame = frame;
	        }

	        public void mouseReleased(MouseEvent e) {
	            mouseDownCompCoords = null;
	        }

	        public void mousePressed(MouseEvent e) {
	            mouseDownCompCoords = e.getPoint();
	        }

	        public void mouseDragged(MouseEvent e) {
	            Point currCoords = e.getLocationOnScreen();
	            frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
	        }
	    }
}