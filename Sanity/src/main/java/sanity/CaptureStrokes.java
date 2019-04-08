package sanity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class CaptureStrokes {
	
public static void main(String[] args) throws Exception {
		
	// final PrintWriter writer = new PrintWriter("C:\\Users\\vipul\\Downloads\\SC\\the-file-name.txt", "UTF-8");
	 File file = new File("C:\\Users\\vipul\\Downloads\\SC\\the-file-name.txt");
		try
		{
			GlobalScreen.registerNativeHook();
			GlobalScreen.addNativeKeyListener(new NativeKeyListener()
			    {  
			    	@Override
			    	public void nativeKeyTyped(NativeKeyEvent nativeEvent) {
					// TODO Auto-generated method stub
					
				}

				@Override
					public void nativeKeyPressed(NativeKeyEvent nativeEvent) {
					// TODO Auto-generated method stub
					
				}
   

			        @Override
			        public void nativeKeyReleased(NativeKeyEvent nativeEvent)
			        {
			            String keyText=NativeKeyEvent.getKeyText(nativeEvent.getKeyCode());
			            String type=keyText;
			            System.out.println(type);
			            if(type.contentEquals("S")||type.contentEquals("s"))
			           
			            {		
			            
			        	//JavaAppendToFile.append(type,file);
			        	
			            }
			        }

					
			       
			     });
		}
			catch (NativeHookException e)
			{
			    //e.printStackTrace();
			}

	}
	

}
