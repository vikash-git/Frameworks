import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class BestSeller2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a[]={"a","b","c","a","b","c","z","z","z"};
		TreeMap <String,Integer>tm=new TreeMap<String,Integer>();
		for(int i=0;i<a.length;i++)
		{
			String temp=a[i];
			if(tm.containsKey(temp))
			{
				tm.put(temp,tm.get(temp)+1);
			}
			else
			{
			tm.put(temp,1);
			}
		}
		 tm= sortByValues(tm);
		 
		    // Get a set of the entries on the sorted map
		    Set set = tm.entrySet();
		 
		    // Get an iterator
		    Iterator i = set.iterator();
		 
		    // Display elements
		    while(i.hasNext()) {
		      Map.Entry me = (Map.Entry)i.next();
		      System.out.print(me.getKey() + ": ");
		      System.out.println(me.getValue());
		    }
		    System.out.println(tm.firstKey());
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static <K, V extends Comparable<V>> TreeMap<K, V> 
    sortByValues(final Map<K, V> map) {
    Comparator<K> valueComparator = 
             new Comparator<K>() {
      public int compare(K k1, K k2) {
        int compare = 
              map.get(k2).compareTo(map.get(k1));
        if (compare == 0) 
          return 1;
        else 
          return compare;
      }
    };
 
    TreeMap<K, V> sortedByValues = 
      new TreeMap<K, V>(valueComparator);
    sortedByValues.putAll(map);
    return sortedByValues;
  }
}
