package tests.Collections;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.Test;

public class ArrayListTest {
	
	@Test
	public void arrayTest() {
		
		List<String> list = new ArrayList<>();
		
		list.add("Cal");
		list.add("Dog");
		list.add("perf");
		
		System.out.println(list);
		
		System.out.println(" ====Adding in existing ArrayList======");
		list.add("alaska");
		System.out.println(list);
		
		System.out.println(" ====remove from ArrayList======");
		list.remove(0);
		System.out.println(list);
		
		System.out.println(" ====Fetch from ArrayList======");
		System.out.println("Second state" + list.get(1));
		
		System.out.println(" ====find string from ArrayList======");
		int position = list.indexOf("alaska");
		System.out.println("index " + position);
		
	}
	
	
	@Test
	public void IterateTest() {
		
		System.out.println(" ====Start : IteratorTest ======");
		List<String> list = new ArrayList<>();
		
		list.add("Cal");
		list.add("Dog");
		list.add("perf");
		
		System.out.println("toString() output");
		System.out.println(list);
		System.out.println("=======");
		
		System.out.println("======  Array List Iterator ======");
		Iterator<String> iterator = list.iterator();
		
		while(iterator.hasNext()) {
			String value = iterator.next();
			System.out.println(value);
		}
		System.out.println("");
		
		System.out.println("======  Array List For Each ======");
		for(String value : list) {
			System.out.println(value);
		}
		System.out.println("");
		
		System.out.println("======  Array List Java8 Reference Method ======");
		list.forEach(System.out::println);
		
		
		System.out.println("======  Array List Java8 Reference Method LABDA ======");
		list.forEach((temp) -> {System.out.println(temp);});
		System.out.println(" ====End : IteratorTest ======");
	}
	
	

}
