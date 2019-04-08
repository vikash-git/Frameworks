/*
 * package sanity;
 * 
 * import java.awt.AWTException; import java.awt.HeadlessException; import
 * java.awt.Rectangle; import java.awt.Robot; import java.awt.Toolkit; import
 * java.awt.image.BufferedImage; import java.io.File; import
 * java.io.FileInputStream; import java.io.FileOutputStream; import
 * java.io.IOException; import java.io.InputStream; import
 * java.util.concurrent.TimeUnit;
 * 
 * import javax.imageio.ImageIO;
 * 
 * //import org.apache.commons.io.IOUtils; import
 * org.apache.poi.openxml4j.exceptions.InvalidFormatException; import
 * org.apache.poi.util.Units; import org.apache.poi.xwpf.usermodel.Document;
 * import org.apache.poi.xwpf.usermodel.XWPFDocument; import
 * org.apache.poi.xwpf.usermodel.XWPFParagraph; import
 * org.apache.poi.xwpf.usermodel.XWPFRun;
 * 
 * public class TakeScreenshots {
 * 
 * public static XWPFRun run; public static XWPFDocument docx;
 * 
 * public static void main(String[] args) throws Exception {
 * 
 * saveScreenshot(); captureScreenshot(); captureScreenshot();
 * captureScreenshot(); saveDoc();
 * 
 * }
 * 
 * 
 * public static void saveScreenshot() throws Exception {
 * 
 * 
 * docx = new XWPFDocument(); XWPFParagraph paragraph = docx.createParagraph();
 * run = paragraph.createRun();
 * 
 * 
 * 
 * FileOutputStream out = new
 * FileOutputStream("C:\\Users\\vipul\\Downloads\\SC\\doc1.docx");
 * docx.write(out); out.flush(); out.close(); docx.close();
 * 
 * TimeUnit.SECONDS.sleep(1);
 * 
 * 
 * 
 * 
 * } public static void captureScreenshot() throws Exception {
 * 
 * 
 * String screenshot_name = System.currentTimeMillis() + ".JPEG"; BufferedImage
 * image = new Robot().createScreenCapture(new
 * Rectangle(Toolkit.getDefaultToolkit().getScreenSize())); ImageIO.write(image,
 * "JPEG", new File("C:\\Users\\vipul\\Downloads\\SC\\" + screenshot_name));
 * InputStream pic = new FileInputStream("C:\\Users\\vipul\\Downloads\\SC\\" +
 * screenshot_name); //docx.addPictureData(pic, Document.PICTURE_TYPE_PNG);
 * run.addBreak(); run.addPicture(pic, XWPFDocument.PICTURE_TYPE_JPEG,
 * screenshot_name, Units.toEMU(500), Units.toEMU(250)); pic.close();
 * 
 * 
 * }
 * 
 * public static void saveDoc() throws IOException, InterruptedException {
 * FileOutputStream out = new
 * FileOutputStream("C:\\Users\\vipul\\Downloads\\SC\\doc1.docx");
 * docx.write(out); out.flush(); out.close(); docx.close();
 * 
 * TimeUnit.SECONDS.sleep(1);
 * 
 * }
 * 
 * 
 * 
 * }
 */