import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;


public class test {
	public static void main(String[]args) throws Exception 
	
	{		String[] items= {"icecream","vikash","vikash","chocolate","candy","chocolate","icecream","apple","icecream","vikash","vikash","icecream","vikash","vikash","icecream","vikash","vikash","icecream","vikash","vikash","icecream","vikash","vikash","icecream","vikash","vikash","icecream","vikash","vikash","icecream","vikash","vikash","icecream","vikash","vikash","icecream","vikash","vikash","icecream","vikash","vikash","icecream","vikash","vikash","icecream","vikash","vikash","icecream","vikash","vikash","icecream","vikash","vikash","icecream","vikash","vikash","icecream","vikash","vikash","icecream","vikash","vikash"};
	
		HashMap<String, Integer> hm = new HashMap<String,Integer>(); 
		for(int i=0;i<items.length;i++)
		{
			if (!hm.containsKey(items[i]))
				hm.put( items[i],1); 
			else
				hm.put(items[i], hm.get(items[i])+1);		
				
		} 
		
       //System.out.println(Sort.Sorting(hm));
       TreeMap<String, Integer> tmap = new TreeMap<String,Integer>();
		int maxValueInMap=(Collections.max(hm.values()));  // This will return max value in the Hashmap
        for (Entry<String, Integer> entry : hm.entrySet()) {  // Itrate through hashmap
            if (entry.getValue()==maxValueInMap) {
            	tmap.put(entry.getKey(), 1);     // Print the key with max value
            }
        }
        
        
        System.out.println(tmap.firstKey());
	}
}
