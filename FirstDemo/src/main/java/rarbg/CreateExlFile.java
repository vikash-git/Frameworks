package rarbg;
import  java.io.*;
import java.util.List;

import  org.apache.poi.hssf.usermodel.HSSFSheet;
import  org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebElement;
import  org.apache.poi.hssf.usermodel.HSSFRow;

public class CreateExlFile{
   
	public static void start(List<WebElement> fname,List<WebElement> date,List<WebElement> size) {
        try {
            String filename = "C:\\Users\\Vikash\\Downloads\\rarbg.xls" ;
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("FirstSheet");  	
            
       
            for (int i = 0; i < fname.size(); i++) 
            {
            	  HSSFRow row = sheet.createRow((short)i);
    			  row.createCell(0).setCellValue(fname.get(i).getText());
    			  row.createCell(1).setCellValue(date.get(i+1).getText());
    			  row.createCell(2).setCellValue(size.get(i+1).getText());
            }
            FileOutputStream fileOut = new FileOutputStream(filename);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            System.out.println("Your excel file has been generated!");

        } catch ( Exception ex ) {
            System.out.println(ex);
        }
    }
}