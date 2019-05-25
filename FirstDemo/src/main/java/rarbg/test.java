package rarbg;

public class test {

	public static void main(String[] args) {
		
		try
		{
		System.out.println(5/0);
		}
		finally {
		System.out.println("inside finally ");
		}
		
		System.out.println("Outside everything ");
		
		
	}

}
