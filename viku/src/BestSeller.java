import java.util.Arrays;

public class BestSeller
{
public static void main(String[] args)
     {
		String[] items= {"a","b","c","a","b","c","z","z"};
	    int count =0;
	    
	    
	    int index[] = new int [660];
	    int indexcpy[] = new int [660];
	     
	    int k=0;
		for(int i=0;i<items.length;i++)
	    	{
	    		for(int j=0;j<items.length;j++)
	    			
	    		{
	    			if(items[i].equals(items[j]))
	    			{
	    				count++;
	    			}
	    					
	    		}	
	    			
	    			
	    				index[k]= count;
	    				k++;
	    			
	    				count=0;
	    	}
	    	
		
		
		System.arraycopy(index,0,indexcpy,0,index.length);
		int max=getLargest(index,index.length);
		//System.out.println(max);
		
		
		 // for(int i=0;i<items.length;i++) { System.out.println(indexcpy[i]); }
		 
		  
		
		 // System.out.println("==============");
		  count=0;
		  for(int i=0;i<indexcpy.length;i++) { 
			  if(indexcpy[i]==max)
				  count++;
		  }
		  
			
		  String kbc[] = new String [count];
		  int t =0;
		
		  for(int i=0;i<items.length;i++)
		{	
			if(indexcpy[i]==max)
				{ kbc[t]=items[i]; 
				t++;}
		}
		  Arrays.sort(kbc);
		  System.out.println(kbc[0]);
			
		  
		/*
		 * 
		 * String kbc2[] = new String [t]; System.arraycopy(kbc,0,kbc2,0,kbc2.length);
		 * Arrays.sort(kbc);
		 * 
		 * 
		 * for(int i=0;i<kbc2.length;i++) { System.out.println(kbc2[i]); }
		 */
		
		
	
   }



public static int getLargest(int[] a, int total){  
int temp;  
for (int i = 0; i < total; i++)   
        {  
            for (int j = i + 1; j < total; j++)   
            {  
                if (a[i] > a[j])   
                {  
                    temp = a[i];  
                    a[i] = a[j];  
                    a[j] = temp;  
                }  
            }  
        }  
       return a[total-1];  
}  
    
}