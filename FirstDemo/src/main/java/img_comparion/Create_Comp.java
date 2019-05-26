package img_comparion;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class Create_Comp {
	
	public static void main(String baseFile, String changeFile,String comp_Path ) throws IOException {		
		//String baseFile ="C:\\Users\\Vikash\\Pictures\\Screenshots\\Baseline\\1.png";
		//String changeFile = "C:\\Users\\Vikash\\Pictures\\Screenshots\\Regression\\1.png";
                //Call method to compare above images.
		compareWithBaseImage(new File(baseFile), new File(changeFile), comp_Path+baseFile.substring(baseFile.lastIndexOf('\\'), baseFile.lastIndexOf('.'))); 
	}
	public static void createPngImage(BufferedImage image, String fileName) throws IOException {
		ImageIO.write(image, "png", new File(fileName));
		System.err.println("!!! Compairison png immage created !!! path =  " +fileName );
		System.out.println("--------------------");
	}
	public static void createJpgImage(BufferedImage image, String fileName) throws IOException {
		ImageIO.write(image, "jpg", new File(fileName));
		System.err.println("!!! Compairison png immage created !!! path =  " +fileName );
		System.out.println("--------------------");
	}
	public static void compareWithBaseImage(File baseImage, File compareImage, String resultOfComparison)
			throws IOException {
		BufferedImage bImage = ImageIO.read(baseImage);
		BufferedImage cImage = ImageIO.read(compareImage);
		int height = bImage.getHeight();
		int width = bImage.getWidth();
		BufferedImage rImage = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				try {
					int pixelC = cImage.getRGB(x, y);
					int pixelB = bImage.getRGB(x, y);
					if (pixelB == pixelC ) {
						rImage.setRGB(x, y,  bImage.getRGB(x, y));
					} else {
						int a= 0xff |  bImage.getRGB(x, y)>>24 , 
						r= 0xff &  bImage.getRGB(x, y)>>16 , 
						g= 0x00 &  bImage.getRGB(x, y)>>8,
						b= 0x00 &  bImage.getRGB(x, y);	
						
						int modifiedRGB=a<<24|r<<16|g<<8|b;
						rImage.setRGB(x,y,modifiedRGB);
					}
				} catch (Exception e) {
					// handled hieght or width mismatch
					rImage.setRGB(x, y, 0x80ff0000);
				}
			}
		}
		String filePath = baseImage.toPath().toString();
		String fileExtenstion = filePath.substring(filePath.lastIndexOf('.'), filePath.length());
		if (fileExtenstion.toUpperCase().contains("PNG")) {
			createPngImage(rImage, resultOfComparison + fileExtenstion);
		} else {
			createJpgImage(rImage, resultOfComparison + fileExtenstion);
		}
	}
}