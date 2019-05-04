package rarbg;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class toupdate_folder_from_pc_to_DB {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		
		
		
        File file = new File("C:\\Users\\Vikash\\Downloads\\Videos\\now2\\");
        String[] fileList = file.list();
        for(String name:fileList)
        {
        	
        	
            System.out.println(name);
            
            
            
        }
        Class.forName("oracle.jdbc.driver.OracleDriver");  
		  
		  
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","TESTING","123@wipro");  
		System.out.println("Connection Successfull");
		Statement st = conn.createStatement();
		
		 for(String name:fileList) {
		
			String name2=name.replaceAll("'", "");
		String sql = "INSERT INTO download  VALUES ('"+name2+"')";
		System.out.println(sql);
		try 
		{
			st.executeUpdate(sql);
		}catch(Exception e)
		{
			System.err.println("th number "+e);
		}
        
        
		 }
		 System.out.println("all printed");
			st.close();

	}

}
