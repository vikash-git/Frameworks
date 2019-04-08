package driver;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class dri {

	public static void main(String[] args) {
		TreeMap<String,String> tm = new TreeMap();
        tm.put("S","CALC");
        tm.put("4", "");
        tm.put("1", "CAsdLC");
        tm.put("1", "CALdfC");
        Set set =tm.entrySet();
        String s=new String("ab");
        System.out.print(s.hashCode());
        //System.out.println(tm.get("5"));
        Iterator itr=set.iterator();
        /*while(itr.hasNext())
        {
        	Map.Entry me = (Map.Entry)itr.next();
        	
        	System.out.println(me.getKey());
        	System.out.println(me.getValue());
        }
*/
	}

}
