import java.util.*;

public class Find_Vowels_from_a_String {


	public static void main(String[] args) 
	{
			Scanner sc= new Scanner(System.in);
			System.out.println("Enter a String");
			String str= sc.nextLine();
			int l=str.length();
			
						
			System.out.println("Vowels in the String are");
			
			for (int i=0;i<l;i++)
			{
				char ch=str.charAt(i);
				if (ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'||ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
				{
					System.out.print(ch);
				}
			
			}
				
			sc.close();
	}

}
