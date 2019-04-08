import java.util.*;
public class Prime_Number {

	
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Number");
		int rng=sc.nextInt();
		int flag=0;
		for (int num= 2;num<=rng;num++)
		{
		
		int i=1;
		flag=0;
			while(i<=num)
			{
				if (num%i==0)
				flag=flag+1 ;
				
				i++;
			}
			
			if (flag<=2)
				System.out.println(num+",");
		
		}
		
		
		
		
		
		}

	}


