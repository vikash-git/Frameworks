package img_comparion;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class Image {
	public static void comp(String baseFile,String changeFile,int ignore) throws IOException {		
		//String baseFile = "C:\\Users\\Vikash\\Pictures\\Screenshots\\1.png";
		
		//String changeFile = "C:\\Users\\Vikash\\Pictures\\Screenshots\\2.png";
                //Call method to compare above images.
		if (ignore==0)
		compareWithBaseImage(new File(baseFile), new File(changeFile), baseFile); 
		else
		compareWithBaseImageIgnoreWhitePixel(new File(baseFile), new File(changeFile), baseFile);
	}

	public static void compareWithBaseImageIgnoreWhitePixel(File baseImage, File compareImage, String baseFile)
			throws IOException {System.err.println("IGNORING WHITE PIXEL");
		BufferedImage bImage = ImageIO.read(baseImage);
		BufferedImage cImage = ImageIO.read(compareImage);
		int height = bImage.getHeight();
		int width = bImage.getWidth();
		float total_count=0;
		float match_count=0;
		float mismatch_count=0;
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				
				try {
					int pixelC = cImage.getRGB(x, y);
					int pixelB = bImage.getRGB(x, y);
					if(pixelC==pixelB&&pixelB==-1)	
					{
					
					}	
					else 
					{
						total_count++;

						if (pixelB == pixelC ) 
						{match_count++;} 
						else 
						{mismatch_count++;}
						
					}
					 
					
				} catch (Exception e) {
					System.out.println(e);
				}
				
				
			}
		}
		
		//System.out.println(total_count);
		//System.out.println(match_count+" match percentage =  "+(match_count*100)/total_count);
		//System.out.println(mismatch_count+"missmatch percentage =  "+(mismatch_count*100)/total_count);
		float match_percnt=(match_count*100)/total_count;
		float mismatch_percnt=(mismatch_count*100)/total_count;
		
		System.out.println("Picture is matching "+match_percnt+"%");
		
		
	}
	
	
	

	
	public static void compareWithBaseImage(File baseImage, File compareImage, String baseFile)
			throws IOException {
		BufferedImage bImage = ImageIO.read(baseImage);
		BufferedImage cImage = ImageIO.read(compareImage);
		int height = bImage.getHeight();
		int width = bImage.getWidth();
		float total_count=0;
		float match_count=0;
		float mismatch_count=0;
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				try {
					total_count++;
					int pixelC = cImage.getRGB(x, y);
					int pixelB = bImage.getRGB(x, y);
					if (pixelB == pixelC ) 
					{
						match_count++;
					} 
					else 
					{
						mismatch_count++;
					}
				} catch (Exception e) {
					
					System.out.println(e);
				}
			}
		}
		
		//System.out.println(total_count);
		//System.out.println(match_count+" match percentage =  "+(match_count*100)/total_count);
		//System.out.println(mismatch_count+"missmatch percentage =  "+(mismatch_count*100)/total_count);
		float match_percnt=(match_count*100)/total_count;
		float mismatch_percnt=(mismatch_count*100)/total_count;
		
		System.out.println("Picture is matching "+match_percnt+"%");
		
		
	}
}