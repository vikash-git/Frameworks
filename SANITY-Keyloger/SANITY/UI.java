

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
	private JFrame frmAutodoc;
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
						window.frmAutodoc.setVisible(true);
					}
				catch (Exception e)
					{
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
		frmAutodoc = new JFrame();
		frmAutodoc.setTitle("\t\tAutoDoc");
		frmAutodoc.setBounds(100, 100, 500, 352);
		frmAutodoc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAutodoc.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 0, 0);
		frmAutodoc.getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JButton btnSave = new JButton("Save N Exit");
		btnSave.setBounds(247, 225, 117, 23);
		frmAutodoc.getContentPane().add(btnSave);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.setBounds(58, 59, 89, 23);
		frmAutodoc.getContentPane().add(btnBrowse);
		
		 pathDisp = new JTextArea();
		 pathDisp.setBackground(UIManager.getColor("Button.background"));
		 pathDisp.setWrapStyleWord(true);
		 pathDisp.setLineWrap(true);
		 pathDisp.setEditable(false);
		 pathDisp.setBounds(189, 58, 261, 113);
		 frmAutodoc.getContentPane().add(pathDisp);
		
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(58, 225, 89, 23);
		frmAutodoc.getContentPane().add(btnStart);
		
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
		btnSave.addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent e)
			{	
				
				try {
					Utill.saveDoc();
					
				} catch (IOException | InterruptedException e1) {
					
					e1.printStackTrace();
				}
				System.exit(0);
			
				
				
			}
		}
				);
		
		
		
		
	}
}
