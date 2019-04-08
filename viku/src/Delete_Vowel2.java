import java.util.*;

public class Delete_Vowel2 {


	public static void main(String args []) 
	{
			Scanner sc= new Scanner(System.in);
			System.out.println("Enter a String");
			String str= sc.nextLine();
			int l=str.length();
	
		
			StringBuilder sb = new StringBuilder(str);
			
			for (int i=0;i<l-1;i++)
			{
				char ch=str.charAt(i);
				if (ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'||ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
				{							 
				 sb=sb.replace(i,i+1,"*");
				 
				 
				 
				 
										
				}
			
			} 

			
	
			String str2=sb.toString();
			
			str2=str2.replace("*","");
			
			System.out.println("INPUT= "+str);
			System.out.println("OUTPUT= "+str2);
			sc.close();
			
			
	}

}



