package Package;

import java.util.Scanner;

public class implicit_wait 
{
	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the first number");
		int a=sc.nextInt();
		System.out.println("Enter the 2nd number");
		int b=sc.nextInt();
		int c=a+b;
		System.out.println(c);
		sc.close();
		
	}
	
}
