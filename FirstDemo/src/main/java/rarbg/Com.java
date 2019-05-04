package rarbg;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Com {
	
	public static ChromeDriver driver;
	public static void compair(List<String> fname,ChromeDriver driver2) throws ClassNotFoundException, SQLException, IOException, InterruptedException, AWTException
	//public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException
	{driver=driver2;
			
		File inputWorkbook = new File("C:\\Users\\Vikash\\Downloads\\compair.xls");
	    Workbook w;
	    try {
	        w = Workbook.getWorkbook(inputWorkbook);
	        // Get the first sheet
	        Sheet sheet = w.getSheet(0);
	        // Loop over first 10 column and lines
	        List<String> excelfilename = new ArrayList<String>();
	        
	        for (int j = 0; j < sheet.getColumns(); j++) 
	        {
	            for (int i = 1; i < sheet.getRows(); i++) 
	            {
	                Cell cell = sheet.getCell(j, i);
	                excelfilename.add(cell.getContents());
	             }
	        }
	       
	        int z=2;
	        for(String curfilename: fname)
	        {
	        	if(excelfilename.contains(curfilename.replaceAll("'", "")))
		        	{
		        		System.out.println("Conatins = "+curfilename); 
		        	} 
	        	else
		        	{
		        		System.err.println("NOT Conatins = "+curfilename);
						download(z);					 
		        	}
	        	z++;
	        	
	        	
	        	
	        }
	        
	        
	      
	        
	        
	    } catch (BiffException e) {
	        e.printStackTrace();
	    }
			
		
		
				
		
		
		
	}

	public static void CreateXls() {
		  try {
          	
          	Class.forName("oracle.jdbc.driver.OracleDriver");  		  
      		Connection connection =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","testing","123@wipro"); 
          	
                 // PreparedStatement psmnt = null;
                  Statement st = connection.createStatement();
                  ResultSet rs = st.executeQuery("Select * from RARBG");

                  @SuppressWarnings("resource")
					HSSFWorkbook wb = new HSSFWorkbook();
                  HSSFSheet sheet = wb.createSheet("Excel Sheet");
                  HSSFRow rowhead = sheet.createRow((short) 0);
                  rowhead.createCell((short) 0).setCellValue("FILE_NAME");
                  

                  int index = 1;
                  while (rs.next()) {

                          HSSFRow row = sheet.createRow((short) index);
                          row.createCell((short) 0).setCellValue(rs.getString(1));
                          
                          index++;
                  }
                  FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Vikash\\Downloads\\compair.xls");
                  wb.write(fileOut);
                  fileOut.close();
                  System.out.println("Data is saved in excel file.");
                  rs.close();
                  connection.close();
          } catch (Exception e) {
          }
		
	}

	
	public static void download(int j) throws InterruptedException, IOException, AWTException
	{
		
				
				//System.out.println(i);
				driver.findElement(By.xpath("//table[@class='lista2t']/tbody/tr["+j+"]/td[2]/a[1]")).click();
				
				
				driver.findElement(By.xpath("//img[@src='https://dyncdn.me/static/20/img/magnet.gif']")).click();
				Thread.sleep(2000);
				//System.out.println("robert started");
				Robot robot = new Robot();	
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_TAB);
				Thread.sleep(1000);
				//System.out.println("TAB Pressed");
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(1000);
				//System.out.println("ENter pressed");
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_TAB);
				Thread.sleep(1000);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				String [] args=new String[2];
				Winium_FDM.main(args);
				System.out.println((j)+" success full PaRTy YoU ShoUlD GiVe ");
		      		
				driver.navigate().back();
				
		  
		
			
		
	}
}
