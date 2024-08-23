package tests.Collections;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

public class MapTest {
	
	@Test
	public void arrayTest() {
		
		Map<String, String> map = new HashMap<>();
		
		map.put("Cal","Caster");
		map.put("Dog", "Desi");
		map.put("perf", "Tools");
		
		System.out.println(map);
		
		System.out.println(" ====Adding in existing Map======");
		map.put("Automation", "Selenium");
		System.out.println(map);
		
		System.out.println(" ====remove from ArrayList======");
		map.remove("Cal");
		System.out.println(map);
		
		System.out.println(" ====Fetch from ArrayList======");
		String cap = map.get("Automation");
		System.out.println("Second state - " + cap);
		
		System.out.println(" ====find string from ArrayList======");
		boolean position = map.containsKey("perf");
		System.out.println("index " + position);
		
	}
	
	
	@Test
	public void IterateTest() {
		
		System.out.println(" ====Start Iterator Test Map ======"); 
		
		
		System.out.println(" ====Unordered Data======");
		Map<String, String> map = new HashMap<>();

		map.put("Cal","Caster");
		map.put("Dog", "Desi");
		map.put("perf", "Tools");
		
		System.out.println(map);
		System.out.println("");
		
		System.out.println(" ====HashMap Iterator======");
		
		Set<String> keys = map.keySet();
		Iterator<String> iterator1  = keys.iterator();
		while(iterator1.hasNext()) {
			String key = iterator1.next();
			System.out.println("The capitol of " + key + " is " + map.get(key));
		}
		System.out.println("");
		
		
		System.out.println(" ====HashMap For Each======");
		
		for(String key : keys) {
			System.out.println("The capitol of " + key + " is " + map.get(key));
		}
		System.out.println("");
		
		System.out.println(" ====END Iterator Test Map ======");
	}

	@Test
	public void FindAverageTest() {

		Map<String,Integer> map = new HashMap<String, Integer>();
		
		map.put("Brian", 21);
		map.put("Lee", 42);
		map.put("Cathe", 21);
		
		System.out.println(map);
		System.out.println("===========FindAverageTest=================");
		
		int val1 = 0;
		
		Set<String> keys = map.keySet();
		for(String key: keys) {
			val1 = val1 + map.get(key);
		}
		
		double average = val1/map.size();
		System.out.println("average - " + average);
		System.out.println("\n");
		
		System.out.println(" ====END FindAverageTest ======");
	}
}
