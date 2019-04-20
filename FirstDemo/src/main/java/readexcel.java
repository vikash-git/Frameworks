



import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class readexcel {

    private String inputFile;

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public void read() throws IOException  {
        File inputWorkbook = new File(inputFile);
        Workbook w;
        try {
            w = Workbook.getWorkbook(inputWorkbook);
            // Get the first sheet
            Sheet sheet = w.getSheet(0);
            // Loop over first 10 column and lines

            for (int j = 0; j < sheet.getColumns(); j++) {
                for (int i = 0; i < sheet.getRows(); i++) {
                    Cell cell = sheet.getCell(j, i);
                    CellType type = cell.getType();
                    if (type == CellType.LABEL) {
                        System.out.println("It took as Label =="+ cell.getContents());
                   }

                    if (type == CellType.NUMBER) {
                        System.out.println("It took as number =="+
                                 cell.getContents());
                    }
                    if (type == CellType.DATE) {
                        System.out.println("It took as date =="+
                                 cell.getContents());
                    }

                }
            }
            
            
            //for pericular coloumn 
            /* for (int i = 0; i < sheet.getRows(); i++)
            {
            	Cell cell = sheet.getCell(1, i);
            	System.out.println(cell.getContents());
            	
            	
            }
           */
            
            
            
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        readexcel test = new readexcel();
        test.setInputFile("C:\\Users\\vikash\\Downloads\\demo.xls");
        test.read();
    }

}
