import java.sql.*;

/**
 * A Java MySQL SELECT statement example.
 * Demonstrates the use of a SQL SELECT statement against a
 * MySQL database, called from a Java program.
 * 
 * Created by Alvin Alexander, http://alvinalexander.com
 */
public class JavaMysqlSelectExample
{

  public static void main(String[] args)
  {
    try
    {
      // create our mysql database connection
      String myDriver = "org.gjt.mm.mysql.Driver";
      String myUrl = "jdbc:mysql://localhost/test";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "");
      
      String query = "SELECT * FROM users";
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery(query);
      while (rs.next())
      {
        int id = rs.getInt("id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        Date dateCreated = rs.getDate("date_created");
        boolean isAdmin = rs.getBoolean("is_admin");
        int numPoints = rs.getInt("num_points");
        
        // print the results
        System.out.format("%s, %s, %s, %s, %s, %s\n", id, firstName, lastName, dateCreated, isAdmin, numPoints);
      }
      st.close();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
  }
}