package sanity;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

public class JavaAppendToFile {

	/**
	 * Java append to file example
	 * 
	 * @param args
	 */
	public static void append(String clip,File file) {
		String filePath = "C:\\Users\\vipul\\Downloads\\SC\\the-file-name.txt";

		String appendText =clip ;

		appendUsingFileWriter(file, appendText);

	//	appendUsingBufferedWriter(filePath, appendText, 2);

		//appendUsingPrintWriter(filePath, appendText);

		//appendUsingFileOutputStream(filePath, appendText);
	}

	private static void appendUsingPrintWriter(String filePath, String text) {
		File file = new File(filePath);
		FileWriter fr = null;
		BufferedWriter br = null;
		PrintWriter pr = null;
		try {
			// to append to file, you need to initialize FileWriter using below constructor
			fr = new FileWriter(file, true);
			br = new BufferedWriter(fr);
			pr = new PrintWriter(br);
			pr.println(text);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				pr.close();
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Use Stream for java append to file when you are dealing with raw data, binary
	 * data
	 * 
	 * @param data
	 */
	private static void appendUsingFileOutputStream(String fileName, String data) {
		OutputStream os = null;
		try {
			// below true flag tells OutputStream to append
			os = new FileOutputStream(new File(fileName), true);
			os.write(data.getBytes(), 0, data.length());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Use BufferedWriter when number of write operations are more
	 * 
	 * @param filePath
	 * @param text
	 * @param noOfLines
	 */
	private static void appendUsingBufferedWriter(String filePath, String text, int noOfLines) {
		File file = new File(filePath);
		FileWriter fr = null;
		BufferedWriter br = null;
		try {
			// to append to file, you need to initialize FileWriter using below constructor
			fr = new FileWriter(file, true);
			br = new BufferedWriter(fr);
			for (int i = 0; i < noOfLines; i++) {
				br.newLine();
				// you can use write or append method
				br.write(text);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Use FileWriter when number of write operations are less
	 * 
	 * @param filePath
	 * @param text
	 * @param noOfLines
	 */
	private static void appendUsingFileWriter(File file, String text) {
		
		FileWriter fr = null;
		try {
			// Below constructor argument decides whether to append or override
			fr = new FileWriter(file, true);
			fr.write(text);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
