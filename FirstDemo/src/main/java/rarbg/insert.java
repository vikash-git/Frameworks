package rarbg;
import java.io.File;
import java.io.IOException;
import java.sql.*;


import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;  
class insert
{  
public static void main(String args[]) throws BiffException, IOException, SQLException, ClassNotFoundException
{  
	 
		
        File inputWorkbook = new File("C:\\Users\\vikash\\Downloads\\rarbg.xls");
        Workbook w;
            w = Workbook.getWorkbook(inputWorkbook);
            // Get the first sheet
            Sheet sheet = w.getSheet(0);
		
		//step1 load the driver class  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		  
		  
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","TESTING","123@wipro");  
		System.out.println("Connection Successfull");
		  			
		
		Statement st = conn.createStatement();
		
		for (int i = 0; i < sheet.getRows(); i++) 
        
		{
			//b=Integer.parseInt(sheet.getCell(0, i).getContents());
			String name=sheet.getCell(0, i).getContents().replaceAll("'", "");
			String date=sheet.getCell(1, i).getContents().replaceAll("'", "");
			String size=sheet.getCell(2, i).getContents().replaceAll("'", "");
		String sql = "INSERT INTO rarbg  VALUES ('"+name+"','"+date+"','"+size+"')";
		//System.out.println(sql);
		st.executeUpdate(sql);
				
		}
		System.out.println("all printed");
		st.close();
		
		
		
	
}  








}
