import java.util.*;

public class Delete_Vowel {


	public static void main(String[] args) 
	{
			Scanner sc= new Scanner(System.in);
			System.out.println("Enter a String");
			String str= sc.nextLine();
			//int l=str.length();
			
			String str2=str;
			
			str2=str2.replace("a","");
			str2=str2.replace("e","");
			str2=str2.replace("i","");
			str2=str2.replace("o","");
			str2=str2.replace("u","");
			str2=str2.replace("A","");
			str2=str2.replace("E","");
			str2=str2.replace("I","");
			str2=str2.replace("O","");
			str2=str2.replace("U","");
			
			System.out.println("INPUT= "+str);
			System.out.println("OUTPUT= "+str2);
		
			
			sc.close();
			
	}

}




