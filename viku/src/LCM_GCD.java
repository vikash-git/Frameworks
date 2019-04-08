import java.util.*;
public class LCM_GCD {
    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
    	
    	System.out.println("Enter the first number");
    	int n1=sc.nextInt();
    	System.out.println("Enter the Secound number");
    	int n2=sc.nextInt();
    	int gcd=1;
        

        for(int i = 1; i <= n1 && i <= n2; i++)
        {
            
            if(n1 % i == 0 && n2 % i == 0)
                gcd = i;
        }

        int lcm = (n1 * n2) / gcd;
      
        System.out.println("The LCM of "+n1+" and "+n2+" is "+ lcm);
        System.out.println("The GCD of "+n1+" and "+n2+" is "+ gcd);
        sc.close();
        
    }
}