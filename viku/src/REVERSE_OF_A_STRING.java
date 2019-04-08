import java.util.*;
public class REVERSE_OF_A_STRING {

	
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the String");
		
		
		String str=sc.nextLine();
		
		StringBuilder sb= new StringBuilder(str);
		
		sb.reverse();
		
		String str2=sb.toString();
		System.out.println(str2);


		
		sc.close();
	}

}
