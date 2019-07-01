package Odh;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class File_copy {

	public static String source_path="C:\\Users\\Vikash\\Downloads\\upLOAD\\test_source\\";
	public static String dest_path="C:\\Users\\Vikash\\Downloads\\upLOAD\\test_dest\\";
	public static String excl_path="C:\\Users\\Vikash\\Downloads\\upLOAD\\test_source\\data.xls";
	public static File file = new File(source_path);
	public static String[] fileList = file.list();
	public static String[] fileList2 =new String[file.list().length];

	 public static List<String> file_list = new ArrayList<String>(fileList.length);
	public static void main(String[] args) throws BiffException, IOException 
	{	
	 
		arrayTOlist();
		int z=0;
		File inputWorkbook = new File(excl_path);
		Workbook w;
        w = Workbook.getWorkbook(inputWorkbook);
        // Get the first sheet
        Sheet sheet = w.getSheet(0);
	
        for (int i = 0; i < sheet.getRows(); i++) 
            
		{ 
        	int count =0;
			
			String f_name=sheet.getCell(0, i).getContents();
			String event_id=sheet.getCell(1, i).getContents();
			
			 for (String temp_filename:fileList)
			 {		 
				if(temp_filename.contains(f_name)&&temp_filename.contains(event_id))
				{
					count++;
					fileList2[z]=temp_filename;
				}
				
			 }
			 if(count!=0)
			 {
				// System.out.println("file found "+"filename="+f_name+" with event id "+event_id);
				 System.out.println(f_name +"\t"+event_id+"\t"+"--Found");
				 
						 z++;
			 }
			 else 
				 //System.out.println("not  found "+"filename="+f_name+" with event id "+event_id);
				 System.out.println(f_name +"\t"+event_id+"\t"+"--Not Found");
		}
        
        
        for (String s:fileList2) {
        	if (s!=null)
        	System.out.println(s);
        }
        
       //create_psv_and_tcf_files();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	private static void arrayTOlist() 
	{
		
	       
	        
	        for (String s:fileList) {
	        	file_list.add( s );
	        }
	       
		
	}












	public static void create_psv_and_tcf_files () 
	{
	
		 
	        
	        for(String name:fileList2)
	        {
	        	if (name.contains(".appd"))
	        	{	
	        	Writer writer = null;
	        	
				
				  File oldfile =new File(source_path+name); System.out.println(oldfile);
				  
				  File newfile =new File(dest_path+name.replaceAll(".appd", ".psv"));
				  
				  if(oldfile.renameTo(newfile)){ System.out.println("File renamed"); }else{
				  System.out.println("Sorry! the file can't be renamed already present in destinaton"); }
				 
	 	       

	 	      try {
	 	          writer = new BufferedWriter(new OutputStreamWriter(
	 	                new FileOutputStream(dest_path+name.replace(".appd",".tcf")), "utf-8"));
	 	          writer.write(name.replaceAll(".appd", ".psv"));
	 	      } catch (IOException ex) {
	 	          // Report
	 	      } finally {
	 	         try {writer.close();} catch (Exception ex) {/*ignore*/}
	 	      }
	 	        
	 	        
	 	        
	 	        
	 	        
	        }}}}
	        
	       
	        
	        
	        
	

	


