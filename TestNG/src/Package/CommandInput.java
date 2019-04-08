package package_TestNG;

import java.text.ParseException;

  
class exec_class extends Thread 
{

	@SuppressWarnings("deprecation")
	public void run()
		{	System.out.println(Thread.currentThread().getName());
			try {
				if (MyGui.txtrSaf.getText().equals("Login Failed : Please Enter Again "))
						{
							String k=Login.command_login(MyGui.getUsername().getText(),MyGui.getPassword().getText() ,MyGui.getDate().getText());
							if (k.equals("Login Failed : Please Enter Again "))
							{	System.out.println("Login Failed please enter password again ");
								
								MyGui.txtrSaf.setText("Login Failed : Please Enter Again ");
								Thread.sleep(5000000);
							}
							if (k.equals("Login SuccessFully"))
							{
							System.out.println("Runing after Methode ");
							My_Wipro.after_Methode(MyGui.getDate().getText());
							}
						}
				else
				My_Wipro.start(MyGui.getUsername().getText(),MyGui.getPassword().getText() ,MyGui.getDate().getText() );
				} 
			catch (ParseException | InterruptedException e)
			{e.printStackTrace();}
		
		}


}
