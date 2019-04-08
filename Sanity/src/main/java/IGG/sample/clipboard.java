package IGG.sample;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class clipboard {
	static String str=new String();
   public static String capture(String[] args) 
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
             str= (String) (t.getTransferData(DataFlavor.stringFlavor)); //Need to type cast or else it is a object retueniong 
         
      } catch (UnsupportedFlavorException | IOException ex) {
          System.out.println("");
      }
	return str;
   }
}