package hashMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class HashMapMainEx {
	public static void main(String[] args) {

		Map<Integer, String> s = new TreeMap<Integer, String>();

		s.put(null, "Akshay");
		s.put(2, null);
		Collection<String> cc=s.values();
		for(String e: cc) {
			System.out.println("=============================================="+e);
		}

		HashMap<Integer, String> hm1 = new HashMap<Integer, String>();
		// Does'nt maintain insertion Order
		// Gives Sorted Output
		hm1.put(4, "value4");
		hm1.put(2, "value2");
		hm1.put(1, "value1");
		hm1.put(3, "value3");
		hm1.put(5, "value4");
		hm1.put(6, "value4");
		hm1.put(7, null);
		hm1.put(8, null);
		System.out.println("Simple output: ----" + hm1);
		// Duplicate keys Ignored
		hm1.put(null, "Nullvalue");
		hm1.put(null, "Newvalue");
		hm1.put(2, "value2NewUpdated");

		hm1.remove(null);
		hm1.replace(2, "Replcaevalue");
		Set<Map.Entry<Integer, String>> hmA = hm1.entrySet();

		Set<Integer> i = hm1.keySet();

		Collection<String> j = hm1.values();

		// USING java 8 forEach
		hm1.entrySet().forEach(item -> System.out.println(item.getKey() + "********" + item.getValue()));

		Iterator<Map.Entry<Integer, String>> itr1 = hmA.iterator();
		// FOReachREEEEEEEEEEEEEEmaining
		itr1.forEachRemaining(itr2 -> System.out.println("USING FORechRemaining" + itr2));
		// FOOOOOOOOOOOOOOOOOOOReach
		for (Entry<Integer, String> entry : hmA) {
			System.out.println("USING FOREach-->KEY:" + entry.getKey() + "---VALUE:" + entry.getValue());
		}

		LinkedHashMap<Integer, String> lhm = new LinkedHashMap<Integer, String>();
		lhm.put(null, "value1");
		lhm.put(10, "value10");
		lhm.put(5, "value1");
		lhm.entrySet().forEach(l -> System.out.println("LHM: ->" + l));

	}
}
