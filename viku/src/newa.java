import java.util.*;
public class newa {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number ");
        int num=sc.nextInt();
        int i=1;
        double fact=1;
        
        while(num>=i)
        {
        fact=fact*i;
        i++;
        }
        double logFactorial = 0;
        for ( i = 2; i <= num; i++) {
          logFactorial += Math.log(i);
        }
       System.out.println("factorial is"+ logFactorial); 
	}
	

}