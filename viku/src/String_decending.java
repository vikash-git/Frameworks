import java.util.*;
public class String_decending 
{
	public static void main(String[] args) 
	{
    	Scanner sc=new Scanner(System.in);
    	
    	System.out.println("Enter a String");
		String str= sc.nextLine();
		int l=str.length();
		
		char arr[] = str.toCharArray();
		
		//Arrays.sort(arr);
		
		char temp;
		
		for (int i = 0; i < l; i++) 
        {
            for (int j=i+1; j<l; j++) 
            {
                if (arr[i] < arr[j]) 
                {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
		
		
		String str2="";
		
		for(int i=0;i<l;i++)
		{
			str2=str2+Character.toString(arr[i]);
		}
			
		System.out.println("INPUT="+str);
		System.out.println("OUTPUT="+str2);
		
		
		
		
		sc.close();	
	}

}
