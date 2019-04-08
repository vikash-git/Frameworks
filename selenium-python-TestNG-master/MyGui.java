package package_TestNG;

//import java.awt.EventQueue;
import javax.swing.JFrame;
//import javax.swing.JSplitPane;
//import java.awt.BorderLayout;
import javax.swing.JButton;
//import javax.swing.SwingConstants;
//import javax.swing.JSeparator;
//import javax.swing.JCheckBox;
//import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
//import javax.swing.Action;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
//import javax.swing.JToggleButton;
import java.awt.Label;


public class MyGui {
	
	private static JFrame frame;
	private static JTextField username;
	private static JPasswordField password;
	private static JTextField date;
	public static Label label ;
	public static JTextArea txtrSaf;
	public static JButton btnStart;

	@SuppressWarnings("static-access")
	public static void main(String[] args) 
	{
		MyGui window = new MyGui();
		window.frame.setVisible(true);
	}
								
	//Create the applicaton 								
	public MyGui() 
	{
		initialize();
	}

	//Initialize the contents of the frame.
	public static  void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 481, 370);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnStart = new JButton("Start");
		btnStart.setBounds(62, 174, 89, 23);
		frame.getContentPane().add(btnStart);
		
		
		
		setUsername(new JTextField());
		getUsername().setBounds(105, 21, 86, 20);
		frame.getContentPane().add(getUsername());
		getUsername().setColumns(10);
		
		setPassword(new JPasswordField());
		getPassword().setBounds(105, 65, 86, 20);
		frame.getContentPane().add(getPassword());
		getPassword().setColumns(10);
		
		setDate(new JTextField());
		getDate().setBounds(105, 118, 86, 20);
		frame.getContentPane().add(getDate());
		getDate().setColumns(10);
		
		txtrSaf = new JTextArea();
		txtrSaf.setEditable(false);
		txtrSaf.setLineWrap(true);
		txtrSaf.setText("Enter the required details");
		txtrSaf.setBounds(256, 52, 158, 62);
		frame.getContentPane().add(txtrSaf);
				
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(24, 24, 71, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(24, 68, 46, 14);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(24, 121, 46, 14);
		frame.getContentPane().add(lblDate);
		
		JLabel lblLogs = new JLabel("Logs");
		lblLogs.setBounds(303, 24, 46, 14);
		frame.getContentPane().add(lblLogs);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(175, 174, 89, 23);
		frame.getContentPane().add(btnClear);
		
		JLabel lblDdmmyyyy = new JLabel("dd/mm/yyyy");
		lblDdmmyyyy.setBounds(10, 133, 71, 14);
		frame.getContentPane().add(lblDdmmyyyy);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(298, 174, 89, 23);
		frame.getContentPane().add(btnExit);
		
		JButton populate = new JButton("Populate");
		populate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username.setText("VI394357@wipro.com");
				password.setText("ft$oct533");
				date.setText("19/11/2018");
				txtrSaf.setText("Populated Successfully");
			}
		});
		populate.setBounds(175, 244, 89, 23);
		frame.getContentPane().add(populate);
		
		//Exit Button action
		btnExit.addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent e)
			{	try{My_Wipro.driver.close();}catch(Exception y) {}
				System.exit(0);
				
			}
		}
				);
	   //Start Button Action 
		btnStart.addActionListener(new ActionListener() 
		{
			@Override
		    public void actionPerformed(ActionEvent e) 
			{	exec_class t=new exec_class();	
				if (txtrSaf.getText().equals("Login Failed : Please Enter Again "))
				{
					t.start();
				}
				else
				t.start();
     
		    }
		});
		//Clear Button Action 
		btnClear.addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent e)
			{
				getUsername().setText("");
				getPassword().setText("");
				getDate().setText("");
				txtrSaf.setText("Cleared Successfully");
			}
		}
				);
	
		
		
	}
	
	//Getter and Setter for all three fields 
	public static JTextField getDate() {
		return date;
	}

	public static void setDate(JTextField date) {
		MyGui.date = date;
	}


	public static JTextField getUsername() {
		return username;
	}

	public static void setUsername(JTextField username) {
		MyGui.username = username;
	}


	public static JPasswordField getPassword() {
		return password;
	}

	public static void setPassword(JPasswordField password) {
		MyGui.password = password;
	}


	
}
