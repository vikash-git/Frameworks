import java.util.*;
public class GCD_OF_ARRAY {
    public static void main(String[] args) 
    
    {
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Enter the number of elements in the array");
    	int l=sc.nextInt();
    	System.out.println("Enter "+l+" elements ");
    
    	int arr[]=new int[l];//Ini
    	
    	
    	for (int i=0;i<l;i++)
    	{
    		arr[i]=sc.nextInt();//insertion
    	}
    	
    		int a=arr[0];
    		GCD_OF_ARRAY obj=new GCD_OF_ARRAY ();
    		
    	for (int i = 1; i < l; i++)
           a = obj.gcd(a,arr[i]);
    		
    	System.out.println("GCD OF ARRAY = "+ a);
    	
    	
    }
    
    
     int gcd (int n1,int n2 )
    {
    	int gcd=1;
    	for(int i = 1; i <= n1 && i <= n2; i++)
    		{
    			if(n1 % i == 0 && n2 % i == 0)
    				gcd = i;
    		}
    	return gcd;
    	
    }
    
    
    
    
}