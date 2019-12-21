import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
//WON'T MAINTAIN THE INSERTION ORDER
public class HashMapEx {
	public static void main(String[] args) {
		HashMap<Integer,String> h1=new HashMap<Integer,String>();
		h1.put(5,"jack");
		h1.put(69, "raju");
		h1.put(9, "barbosa");
		h1.put(0, "jaggu");
		h1.put(1, "william");
		HashMap<Integer,String> hd=new HashMap<Integer,String>();
		hd.put(66, "thanu");
		hd.put(33, "manaaaa");
		h1.putAll(hd);
		System.out.println("==============================================");
		System.out.println("the entry sett is________________: "+h1.entrySet());
		System.out.println("the values areeee ________________: "+h1.values());

		System.out.println("the putAll() method will join collection inside collections"+h1);
		System.out.println("the values by get(): "+h1.get(5));
		//we cant make use of add method in HASHMAP
		Set<Map.Entry<Integer, String>> s1=h1.entrySet();
		for(Map.Entry<Integer, String> e1:s1) {
			System.out.println(e1.getKey());
			System.out.println(e1.getValue());
		}
		System.out.println("the hashmap keys are: "+h1.keySet());

		HashMap<Integer,StudentEX> h2=new HashMap<Integer,StudentEX>();
		h2.put(5, new StudentEX(22,"akshu"));
		h2.put(9, new StudentEX(23,"mowna"));
		h2.put(2, new StudentEX(26,"kavya"));
		h2.put(7, new StudentEX(26,"kavya"));
		h2.put(6, null);
		h2.put(3, null);

		Collection<StudentEX> c1=h2.values();
		for (StudentEX entry : c1) {
			System.out.println(entry);
		}


		h2.put(null, new StudentEX(33,"manu"));

		System.out.println("key cant be duplicated and key can be null(for manu we have null key");
		System.out.println("if we given duplicate key then reassign will happen,now replacing akshu with yashu");

		h2.put(5, new StudentEX(66,"yashu"));
		Set z=h2.keySet();
		System.out.println("all key are: ");
		System.out.println(z);

		for (StudentEX entry : c1) {
			System.out.println(entry);
		}

		System.out.println(h2.containsKey(9));
		System.out.println(h2.containsValue(new StudentEX(22,"akshu")));	
	}
}
