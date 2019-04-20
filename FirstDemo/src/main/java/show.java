import java.sql.*;  
class show
{  
public static void main(String args[])
{  
	try{  
		//step1 load the driver class  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		  
		  
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","testing","123@wipro");  
		  
		
		
		/***
		 * showing a table 
		 */
		
		String query = "SELECT * FROM Persons order by PersonID asc";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		while (rs.next())
		{	  
		  String firstName = rs.getString("PersonID");
		  String lastName = rs.getString("LastName");
		  String dateCreated = rs.getString("FirstName");
		  String isAdmin = rs.getString("Address");
		  String numPoints = rs.getString("City");
		  
		  // print the results
		  System.out.format(" %s, %s, %s, %s, %s\n",  firstName, lastName, dateCreated, isAdmin, numPoints);
		
		
		
		}
		st.close();
	}catch (Exception e)
    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
}  
}
