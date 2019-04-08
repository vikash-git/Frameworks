package Package;

import java.util.Scanner;

public class interview {
public static void main(String[] args) 
{
	Scanner sc = new Scanner(System.in);
	System.out.println("string 1");
	String s1=sc.nextLine();
	System.out.println("string 2");
	String s2=sc.nextLine();
	
	for(int i=0;i<=s1.length()-1;i++)
	{
		char v=s1.charAt(i);
		String str= Character.toString(v);
	if(!s2.contains(str))
	{
		System.out.println(str);
	}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	for(int i=0;i<=s1.length()-1;i++)
	{
		for(int j=0;j<=s2.length()-1;j++)
		{				
			if(ch1[i]==ch2[j])
			{
				count++;
			}
		}
		if(count==1)
			{
			System.out.println(ch1[i]);
			}
		count=1;
	}*/
	sc.close();
	
}

}
