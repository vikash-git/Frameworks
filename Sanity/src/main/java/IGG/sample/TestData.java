package IGG.sample;


import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TestData {

    private String inputFile;

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public void read() throws IOException  {
       // File inputWorkbook = ;
        ;
        try {
        	Workbook w = Workbook.getWorkbook(new File("C:\\Users\\vx00783\\Downloads\\Book1.xls"));
            // Get the first sheet
            Sheet sheet = w.getSheet(0);
            // Loop over first 10 column and lines

           
            
            
            //for pericular coloumn 
             for (int i = 0; i < sheet.getRows(); i++)
            {
            	Cell cell = sheet.getCell(1, i);
            	System.out.println(cell.getContents());
            	
            	
            }
           
            
            
            
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TestData test = new TestData();
        test.setInputFile("C:\\Users\\vx00783\\Downloads\\Book1.xls");
        test.read();
    }

}