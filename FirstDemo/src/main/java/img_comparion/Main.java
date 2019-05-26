package img_comparion;

import java.io.File;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException 
	{		/****
				#1 for comparing both picture should have same resolution.
				#2 need to create a document with baseline shot -regression shot --comparison to add
				#3 need 
	
			****/
		
			String baseline="C:\\Users\\Vikash\\Pictures\\Screenshots\\Baseline\\";
			String regression="C:\\Users\\Vikash\\Pictures\\Screenshots\\Regression\\";
			String comparing_path="C:\\Users\\Vikash\\Pictures\\Screenshots\\Comparison\\";
		 File file = new File(baseline);
	        String[] b_file = file.list();
	       
	        File file2 = new File(regression);
	        String[] r_file = file2.list();
	        
	        /*for(String name:fileList)
	        {System.out.println("Files under baseline folder");System.out.println(name);}
	          for(String name:fileList2)
			  {System.out.println("Files under baseline folder");System.out.println(name);}
	         */
	        
		
	        for(int i=0;i<b_file.length;i++)
	        {	System.out.println("--------------------");
	        	System.out.println("COMPARING BETWEEN");
	        	System.out.println(baseline+b_file[i]);
	        	System.out.println("AND");
	        	try {
	        	System.out.println( regression+r_file[i]);
	        	
	        	
	        	System.out.println("--------------------");
	        	Image.comp(baseline+b_file[i], regression+r_file[i],0);//put 1 to ignore white pixel and 0 not to ignore
	        	Create_Comp.main(baseline+b_file[i],  regression+r_file[i], comparing_path);
	        	}catch(Exception e)
	        	{System.out.println("No file present in regression directory");}
	        	System.out.println();
	        	System.out.println();
	        	
	        	
	        	
	        }
	        
		
		
	}

}
