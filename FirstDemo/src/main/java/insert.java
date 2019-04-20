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
	 
		
        File inputWorkbook = new File("C:\\Users\\vikash\\Downloads\\demo.xls");
        Workbook w;
            w = Workbook.getWorkbook(inputWorkbook);
            // Get the first sheet
            Sheet sheet = w.getSheet(0);
		
		//step1 load the driver class  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		  
		  
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","TESTING","123@wipro");  
		System.out.println("Connection Successfull");
		  			
		
		Statement st = conn.createStatement();
		
		for (int i = 1; i < sheet.getRows(); i++) 
        
		{
			//b=Integer.parseInt(sheet.getCell(0, i).getContents());
			
		String sql = "INSERT INTO Persons  VALUES ('"+sheet.getCell(0, i).getContents()+"', '"+sheet.getCell(1, i).getContents()+"', '"+sheet.getCell(2, i).getContents()+"', '"+sheet.getCell(3, i).getContents()+"', '"+sheet.getCell(4, i).getContents()+"')";
		System.out.println(sql);
		st.executeUpdate(sql);
			//st.executeUpdate("INSERT INTO Persons VALUES ('1', 'Schoroder', 'Davie', '783 Lunder Parkway', 'Pavlovka')");	
		}
		System.out.println("all printed");
		st.close();
		
		
	
}  








}
