package IGG.sample;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.aspose.ocr.CorrectionFilters;
import com.aspose.ocr.ImageStream;
import com.aspose.ocr.OcrEngine;
import com.aspose.ocr.filters.GaussBlurFilter;
import com.aspose.ocr.filters.MedianFilter;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

/**
 * Hello world!
 *
 */
public class App 
{
    
	public static void main( String[] args ) throws IOException, TesseractException
    {
    	// create an instance of OcrEngine
    	System.out.println("hai");
    	File file=new File("C:\\Users\\vipul\\Downloads\\image1.png");
    	BufferedImage image=ImageIO.read(file);
    	ITesseract t=new Tesseract();
    	t.setDatapath("C:\\Users\\vipul\\eclipse-workspace\\sample\\tessract\\tessdata");
    	File file1=new File("C:\\Users\\vipul\\Downloads\\image111.png");

BufferedImage out=new BufferedImage(200,100,BufferedImage.TYPE_BYTE_GRAY);

int p = (255<<24) | (100<<16) | (150<<8) | 200;
for(int j=0;j<image.getWidth();j++)
{
	for(int i=0;i<image.getHeight();i++)
	{
		p=image.getRGB(j, i);
		Color c=new Color(p);
		if((c.getRed()>140&&c.getRed()<150))
		{
		image.setRGB(j, i, Color.ORANGE.getRGB());
		}
	}
}

ImageIO.write(image, "png", file1);
		/*
		 * for(int i=0;i<image.getHeight();i++) { for(int j=0;j<image.getWidth();j++) {
		 * int pixel=image.getRGB(j, i);
		 * 
		 * &&(c.getGreen()>50&&c.getGreen()>70)&&(c.getBlue()>70&&c.getBlue()<90)
		 * } }
		 */
		/*
		 * Color c=new Color(pixel);
    			out.setRGB(j, i, p);
		 * if(c.getRed()>240) { ImageIO.write(out,"png",file1);
		 * System.out.println(pixel); }
		 */
    }
}
