package rarbg;

import java.sql.*;  
class DB_update2
{  
public static void main(String[]args)
{  
	try{  
		
		//step1 load the driver class  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		  
		  
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","testing","123@wipro");  
		  
		
		
		/***
		 * showing a table 
		 */
		
		String query = "SELECT * FROM rarbg";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		while (rs.next())
		{	  
		  String filename = rs.getString("FILE_NaME");
		  String date = rs.getString("ADDED_DATE");
		  String filesize = rs.getString("FILE_SIZE");
		  
		  
		  // print the results
		  System.out.format(" %s, %s, %s, \n",  filename, date, filesize);
		
		
		
		}
		st.close();
	}catch (Exception e)
    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
}  
}
