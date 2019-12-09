package com.framework;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import java.nio.file.*;
public class Utill 
{	public static XWPFRun run;
	public static XWPFDocument docx;
	public static String path1=new String();
	static String clip=new String();
	public static Integer textCount=0;
	public static Integer imgCount=0;
	
	
	
	public static void docInitialization() throws Exception 
	{

    	
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
	
	public static void startKeyCapturing()
	{
		try
			{
				GlobalScreen.registerNativeHook();
				GlobalScreen.addNativeKeyListener(new NativeKeyListener()
				    {  
				    	@Override
				    	public void nativeKeyTyped(NativeKeyEvent nativeEvent) 
				    	{
						// TODO Auto-generated method stub
						
				    	}
		
				    	@Override
						public void nativeKeyPressed(NativeKeyEvent nativeEvent)
				    	{
						// TODO Auto-generated method stub
						
				    	}
		
		
				        @Override
				        public void nativeKeyReleased(NativeKeyEvent nativeEvent)
				        {
				            String keyText=NativeKeyEvent.getKeyText(nativeEvent.getKeyCode());
				            String type=keyText;
				            System.out.println(type);
				            if (type.contentEquals("Insert"))
					            {textCount++;
					            	clip=clipboardCapture();
					            	try {
										captureScreenshot("TEXT");
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
					            	
					            }
				            
				            
				            if(type.contentEquals("F9")||type.contentEquals("F9"))
					            {imgCount++;
					            	try 
					            		{
					            			captureScreenshot("PIC");
									
					            
					            		} 
					            	catch (Exception e) 
					            		{
											e.printStackTrace();
					            		}
					            }
				        }
		
						
				       
				     }
				);
						}
		catch (NativeHookException e)
			{
			    e.printStackTrace();
			}

	}
	
	public static void captureScreenshot(String str) throws Exception
    {
    	 if(str.equals("PIC"))
    	 {
			    String screenshot_name = System.currentTimeMillis() + ".JPEG";
			    BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			    ImageIO.write(image, "JPEG", new File(path1 + screenshot_name));

			    InputStream pic = new FileInputStream(path1 + screenshot_name);
			    //docx.addPictureData(pic, Document.PICTURE_TYPE_PNG);
			    
			    run.addPicture(pic, XWPFDocument.PICTURE_TYPE_JPEG, screenshot_name, Units.toEMU(500), Units.toEMU(250));
			    run.addCarriageReturn();
			    run.setText("\n");
	    		 run.addCarriageReturn();
			    pic.close();
			    Files.deleteIfExists(Paths.get(path1 + screenshot_name));
    	 }
    	 if(str.equals("TEXT"))
    	 {
    		 
    		 System.out.println(clip);
    		 
    		 run.setText(clip);
    		 run.addCarriageReturn();
    		 run.setText("\n");
    		 run.addCarriageReturn();
    	 }
			    
			    
	    	
    	
    }
	
	
	
	public static void saveDoc() throws IOException, InterruptedException
	    {
	    	FileOutputStream out = new FileOutputStream(UI.path);
	 	    docx.write(out);
	 	    out.flush();
	 	    out.close();
	 	    docx.close();

	 	    TimeUnit.SECONDS.sleep(1);		
			
	    }
	 
	public static String browseBtn() {
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getParentDirectory(new File("C:\\")));
		//JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

		//int returnValue = jfc.showOpenDialog(null);
		 int returnValue = jfc.showSaveDialog(null);
		 File selectedFile = jfc.getSelectedFile();
		if (returnValue == JFileChooser.APPROVE_OPTION) 
		{
			
			System.out.println(selectedFile.getAbsolutePath());
			
		
		}
		return selectedFile.getAbsolutePath() ;
		
	}

	public static String pathInitialization()
	{
		String path =UI.path;
		int index=path.lastIndexOf("\\");
		  path1=path.substring(0,index+1); 
		  System.out.println(path1);
		
		
		return null;
		
	}

	public static String clipboardCapture() 
	   {

	      // This represents a cut-copy (Ctrl+X/Ctrl+C) operation.
	      // The text will be copied to the clipboard
	     

			/*
			  StringSelection data = new StringSelection("This is copied to the clipboard"); 
			  Clipboard cb =Toolkit.getDefaultToolkit().getSystemClipboard();
			   cb.setContents(data, data);
			 */

	      // This represents the paste (Ctrl+V) operation
		   Clipboard cb =Toolkit.getDefaultToolkit().getSystemClipboard();
	      try {
	         Transferable t = cb.getContents(null);
	         if (t.isDataFlavorSupported(DataFlavor.stringFlavor))
	             clip= (String) (t.getTransferData(DataFlavor.stringFlavor)); //Need to type cast or else it is a object retueniong 
	         
	      } catch (UnsupportedFlavorException | IOException ex) {
	          System.out.println("");
	      }
		return clip;
	   }
	
}