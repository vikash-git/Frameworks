/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	 BigInteger bi1 = new BigInteger("3"); 
BigInteger bi2 = new BigInteger("2"); 
BigInteger bi3 = new BigInteger("1");
BigInteger bi0 = new BigInteger("0");

BigInteger bigSum = bi1.add(bi2);

BigInteger bigProduct = bi1.multiply(bi2);

System.out.println("Sum : " + bigSum);
System.out.println("Product : " + bigProduct);

for(int comparevalue = bi1.compareTo(bi0);comparevalue!=0; bi1=bi1.subtract(bi3)) 
{   comparevalue = bi1.compareTo(bi0);
    bi2=bi2.multiply(bi2);
   
    
}
System.out.println(bi2);
//System.out.println("Power="+bi2.pow(82589933));
//System.out.println("function "+pow(bi2,bi1));
     }
     
     
    public static BigInteger pow(BigInteger base, BigInteger exponent) {
  BigInteger result = BigInteger.ONE;
  while (exponent.signum() > 0) {
    if (exponent.testBit(0)) result = result.multiply(base);
    base = base.multiply(base);
    exponent = exponent.shiftRight(1);
  }
  return result;
	}
}
