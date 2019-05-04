package rarbg;
import java.io.*;
import java.io.FileOutputStream;
import java.sql.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;

public class ExcelFile {
        public static void main(String[] args) 
        {
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
}