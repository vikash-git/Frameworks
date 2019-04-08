package sanity;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

class p2
{
	 	public static XWPFRun run;
	    public static XWPFDocument docx;
	    
	    
	public static void main(String[] args) throws Exception {
		
		Sanity.GUI(args);
		saveScreenshot();
			
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
			            {	try {
			            	
			            	
								captureScreenshot();
							
			            
			            } catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}}
			        }

					
			       
			     });
		}
			catch (NativeHookException e)
			{
			    //e.printStackTrace();
			}

	}
	

	 public static void saveScreenshot() throws Exception {

        	
  	   docx = new XWPFDocument();
  	    XWPFParagraph paragraph = docx.createParagraph();    
  	     run = paragraph.createRun();
  	    
  	    
		/*
		 * FileOutputStream out = new
		 * FileOutputStream("C:\\Users\\vipul\\Downloads\\SC\\doc1.docx");
		 * docx.write(out); out.flush(); out.close(); docx.close();
		 * 
		 * TimeUnit.SECONDS.sleep(1);
		 */
  	
  	
  	
  }
	 public static void captureScreenshot() throws Exception
	    {
	    	 
		    
				    String screenshot_name = System.currentTimeMillis() + ".JPEG";
				    BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
				    ImageIO.write(image, "JPEG", new File("C:\\Users\\vipul\\Downloads\\SC\\" + screenshot_name));
				    InputStream pic = new FileInputStream("C:\\Users\\vipul\\Downloads\\SC\\" + screenshot_name);
				    //docx.addPictureData(pic, Document.PICTURE_TYPE_PNG);
				    run.addBreak();
				    run.addPicture(pic, XWPFDocument.PICTURE_TYPE_JPEG, screenshot_name, Units.toEMU(500), Units.toEMU(250));
				    pic.close();
		    	
	    	
	    }
	 public static void saveDoc() throws IOException, InterruptedException
	    {
	    	 FileOutputStream out = new FileOutputStream("C:\\Users\\vipul\\Downloads\\SC\\doc1.docx");
	 	    docx.write(out);
	 	    out.flush();
	 	    out.close();
	 	    docx.close();

	 	    TimeUnit.SECONDS.sleep(1);		
			
	    }

}