package Cpos_Onesource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Epass {
	public static String excel_path= "C:\\Users\\Vikash\\Desktop\\links.xls";
	public static String evidence_document_path= "C:\\Users\\Vikash\\Desktop\\";
	public static String baseline_url= "https://www.google.com/";
	public static String regression_url= "https://www.facebook.com/" ;
	public static String driver_path= "C:\\Users\\Vikash\\git\\Frameworks\\FirstDemo\\src\\main\\java\\rarbg\\chromedriver.exe";
	
	public static ArrayList<String> url=new ArrayList<String>();
	public static ArrayList<String> file_name=new ArrayList<String>();
	public static WebDriver driver;
	public static XWPFDocument doc = new XWPFDocument();
	public static XWPFParagraph p = doc.createParagraph();
	public static XWPFRun r = p.createRun();
	
	
	
	public static void main(String[] args) throws IOException, InterruptedException, InvalidFormatException 
	{
		System.out.println("Launching Chrome");
		driver_initialize();
		System.out.println("Reading URLs from excel .......");
		read_urls_from_excel();
		System.out.println("Capturing all the Urls Please Wait ....");
		open_url();
		driver_close();
		System.err.println("all "+url.size()+" links captured");
		System.err.println("path : ./screenshots/" );
		evidence_create();
		System.out.println("Creating Document...");
		doc_close();
		System.err.println("Document created");
		System.err.println("Path : "+evidence_document_path+"word_images.docx" );
				
		
	}

	private static void doc_close() throws IOException {
		FileOutputStream out = new FileOutputStream(evidence_document_path+"word_images.docx");
		doc.write(out);
		out.close();
		doc.close();
		
	}

	private static void evidence_create() throws InvalidFormatException, IOException 
	{
		for(int index=0;index<url.size();index++)
		{
			WordDocumentApp(url.get(index),file_name.get(index));
			
		}
		
		
		
	}

	private static void WordDocumentApp(String url, String filename) throws InvalidFormatException, IOException
	{
		File image1 = new File("./screenshots/"+filename);
		addImagesToWordDocument(image1,url,filename);
		
	}

	private static void driver_close() {
		driver.close();
		driver.quit();
		
	}

	
	private static void open_url() throws InterruptedException {
		
		for(int index=0;index<url.size();index++)
		{
			driver.get(url.get(index));
			Thread.sleep(2000);
			capturescreen();
			
		}
	}
	
	
	private static void driver_initialize() {
		 System.setProperty("webdriver.chrome.driver", driver_path);     
         driver = new ChromeDriver();
         driver.manage().window().maximize();
       	
		
	}

	private static void read_urls_from_excel() throws IOException {
		File inputWorkbook = new File(excel_path);
        Workbook w;
        try {
	            w = Workbook.getWorkbook(inputWorkbook);
	            Sheet sheet = w.getSheet(0);
	            for (int j = 0; j < sheet.getColumns(); j++) 
	               	{
	          		for (int i = 0; i < sheet.getRows(); i++) 
	                    { 
	                		Cell cell = sheet.getCell(j, i);
	                		url.add(baseline_url+cell.getContents());
	                		url.add(regression_url+cell.getContents());
	                    }
	               	}
	        } 
        catch (BiffException e) {
	            e.printStackTrace();
	        }
		
	}
	
	public static void capturescreen() //Capture Screen Methode
	{ 
		
			TakesScreenshot ts = (TakesScreenshot)driver;
			File f = (File) ts.getScreenshotAs(OutputType.FILE);
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			String str=dateFormat.format(date).toString();
			
			str=str.replaceAll("/", "");
			str=str.replaceAll(":", "");
			str=str.replaceAll(" ","");
			System.out.println(str);
			file_name.add(str.concat(".jpg"));
			String str2= "./screenshots/"+str+".jpg";
			
			File f1 = new File (str2); 
			try {
				FileUtils.copyFile(f,f1);
				} 
			catch (IOException e)
				{
				e.printStackTrace();
				}
		}

	public static void addImagesToWordDocument(File imageFile1, String url,String filename)throws IOException, InvalidFormatException {
		
		
		String imgFile1 = imageFile1.getName();
		int imgFormat1 = getImageFormat(imgFile1);
		String p1 = url;
		r.setText(p1);
		r.addBreak();
		r.setText(filename);
		r.addBreak();
		r.addPicture(new FileInputStream(imageFile1), imgFormat1, imgFile1, Units.toEMU(500), Units.toEMU(250));
		r.addBreak();
		r.addBreak();
		
	}

	private static int getImageFormat(String imgFileName) {
		int format;
		if (imgFileName.endsWith(".emf"))
			format = XWPFDocument.PICTURE_TYPE_EMF;
		else if (imgFileName.endsWith(".wmf"))
			format = XWPFDocument.PICTURE_TYPE_WMF;
		else if (imgFileName.endsWith(".pict"))
			format = XWPFDocument.PICTURE_TYPE_PICT;
		else if (imgFileName.endsWith(".jpeg") || imgFileName.endsWith(".jpg"))
			format = XWPFDocument.PICTURE_TYPE_JPEG;
		else if (imgFileName.endsWith(".png"))
			format = XWPFDocument.PICTURE_TYPE_PNG;
		else if (imgFileName.endsWith(".dib"))
			format = XWPFDocument.PICTURE_TYPE_DIB;
		else if (imgFileName.endsWith(".gif"))
			format = XWPFDocument.PICTURE_TYPE_GIF;
		else if (imgFileName.endsWith(".tiff"))
			format = XWPFDocument.PICTURE_TYPE_TIFF;
		else if (imgFileName.endsWith(".eps"))
			format = XWPFDocument.PICTURE_TYPE_EPS;
		else if (imgFileName.endsWith(".bmp"))
			format = XWPFDocument.PICTURE_TYPE_BMP;
		else if (imgFileName.endsWith(".wpg"))
			format = XWPFDocument.PICTURE_TYPE_WPG;
		else {
			return 0;
		}
		return format;
	}
	
}

