package sanity;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

public class Sanity {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;

   public Sanity(){
      prepareGUI();
   }
   public static void GUI(String[] args){
      Sanity  swingListenerDemo = new Sanity();  
      swingListenerDemo.showKeyListenerDemo();
   }
   private void prepareGUI(){
      mainFrame = new JFrame("Java SWING Examples");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));

      headerLabel = new JLabel("",JLabel.CENTER );
      statusLabel = new JLabel("",JLabel.CENTER);        
      statusLabel.setSize(350,100);
      
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }
   private JTextField textField;
   private void showKeyListenerDemo(){
      headerLabel.setText("Listener in action: KeyListener");      
      textField  = new JTextField(10);
      textField.addKeyListener(new CustomKeyListener());
      JButton okButton = new JButton("OK");
      
      okButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) 
         
         {
            try {
				p2.saveDoc();
				System.exit(0);
			} catch (IOException | InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
            
            // need to write the code
         }
      });
      controlPanel.add(textField);
      controlPanel.add(okButton);    
      mainFrame.setVisible(true);  
   }
   class CustomKeyListener implements KeyListener{
      public void keyTyped(KeyEvent e) {
      }
      public void keyPressed(KeyEvent e) {
         if(e.getKeyCode() == KeyEvent.VK_ENTER){
            statusLabel.setText("Entered text: " + textField.getText());
         }
      }
      public void keyReleased(KeyEvent e) {
      }   
   }
}