package tests.Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

public class CollectionPrograms {

	
	String[] array = {"Red", "Green", "Blue"};

	//@Test
	public void ConvertanArrayintoCollectioninJava() {
		System.out.println("-----Inside -----Convert an Array into Collection in Java===========");
		
		List<String> list = Arrays.asList(array);
		
		System.out.println(list);
		for (String element : list) {
            System.out.println(element);
        }	
	}
	
	//@Test
	public void JavaProgramtoChangeaCollectiontoanArray() {
		System.out.println("-----Inside -----Java Program to Change a Collection to an Array===========");
		List<String> list = Arrays.asList(array);
		
		String[] a1 = list.toArray(new String[list.size()]); 
		System.out.println("Array elements:");
        for (String element : a1) {
            System.out.println(element);
        }
		
	}
	
	//@Test
	public void JavaProgramtoCompareElementsinaCollection() {
		System.out.println("-----Inside -----Java Program to Compare Elements in a Collection===========");
		
		List<String> people = new ArrayList<>();
		people.add("Dev");
		people.add("AND");
		people.add("Raj");
		
		for (String element : people) {
			if(element.toString() == "Raj") {
				System.out.println(element);
			}
        }
		
	}
	
	//@Test
	public void HowtoPrintaCollectioninJava() {
		System.out.println("-----Inside -----How to Print a Collection in Java?===========");
		
		
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
		

	}
	
	//@Test
	public void HowtoMakeaCollectionReadOnlyinJava() {
		System.out.println("-----Inside -----How to Make a Collection Read-Only in Java?===========");
		// Create an ArrayList
        List<String> originalList = new ArrayList<>();
        originalList.add("apple");
        originalList.add("banana");
        originalList.add("cherry");
        
        // Make the ArrayList read-only
        List<String> readOnlyList = Collections.unmodifiableList(originalList);
        
        // Try to modify the read-only list (this will throw UnsupportedOperationException)
        try {
            readOnlyList.add("date");
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify read-only list: " + e.getMessage());
        }
        
        // Access elements of the read-only list
        System.out.println("Read-only list elements:");
        for (String element : readOnlyList) {
            System.out.println(element);
        }
	}
	
	//@Test
	public void JavaProgramtoRemoveaSpecificElementFromaCollection() {
		System.out.println("-----Inside -----Java Program to Remove a Specific Element From a Collection===========");
		 List<String> arrayList = new ArrayList<>();
	        arrayList.add("apple");
	        arrayList.add("banana");
	        arrayList.add("cherry");
	        
	        // Print ArrayList before removal
	        System.out.println("ArrayList elements before removal: " + arrayList);
	        
	        // Remove "banana" from ArrayList
	        boolean removed = arrayList.remove("banana");
	        
	        if (removed) {
	            System.out.println("Removed 'banana' from ArrayList");
	        } else {
	            System.out.println("'banana' not found in ArrayList");
	        }
	}
	
	//@Test
	public void CollectionsreverseMethodinJavawithExamples() {
		System.out.println("-----Inside -----Collections.reverse() Method in Java with Examples===========");
		
		List<String> arrayList = new ArrayList<>();
        arrayList.add("apple");
        arrayList.add("banana");
        arrayList.add("cherry");
        
        // Print ArrayList before removal
        System.out.println("ArrayList elements before removal: " + arrayList);
        
        
       Collections.reverse(arrayList);
        
        System.out.println(arrayList);

	}
	
	//@Test
	public void CollectionsshuffleMethodinJavawithExamples() {
		System.out.println("-----Inside -----Collections.shuffle() Method in Java with Examples===========");
		
		List<String> arrayList = new ArrayList<>();
        arrayList.add("apple");
        arrayList.add("banana");
        arrayList.add("cherry");
        
        // Print ArrayList before removal
        System.out.println("ArrayList elements before removal: " + arrayList);
        
        
       Collections.shuffle(arrayList);
        
        System.out.println(arrayList);

	}
	
	//@Test
	public void HowtoGetaSizeofCollectioninJava() {
		System.out.println("-----Inside -----How to Get a Size of Collection in Java?===========");
		
		List<String> arrayList = new ArrayList<>();
        arrayList.add("apple");
        arrayList.add("banana");
        arrayList.add("cherry");
        
        // Print ArrayList before removal
        System.out.println("ArrayList elements before removal: " + arrayList);
        
        System.out.println(arrayList.size());
        
        
        Map<String, String> map = new HashMap<>();

		map.put("Cal","Caster");
		map.put("Dog", "Desi");
		map.put("perf", "Tools");
		
		System.out.println(map);
		System.out.println(map.size());
	}
	
	//@Test
	public void HowtoIterateHashMapinJava() {
		System.out.println("-----Inside -----How to Iterate HashMap in Java?===========");
		Map<String, String> map = new HashMap<>();

		map.put("Cal","Caster");
		map.put("Dog", "Desi");
		map.put("perf", "Tools");
		
		System.out.println(map);
		
		System.out.println("======  Array List Iterator ======");
		Set<String> keys = map.keySet();
		Iterator<String> iterator = keys.iterator();
		
		while(iterator.hasNext()) {
			String key = iterator.next();
			System.out.println("The value of key - " + key + " is - " + map.get(key));
		}
		System.out.println("");
		
		System.out.println("======  Array List For Each ======");
		for(String key : keys) {
			System.out.println("The value of key - " + key + " is - " + map.get(key));
		}
		System.out.println("");
		
				
		
	}
	
	//@Test
	public void MinandMaxinaListinJava() {
		System.out.println("-----Inside -----Min and Max in a List in Java===========");
		
		Integer[] array = {1,2,3,4,5,6,7,8,9,0};
		List<Integer> integers = Arrays.asList(array);
		
		System.out.println("List of integers: " + integers);
        System.out.println("Minimum value: " + Collections.min(integers));
        System.out.println("Maximum value: " + Collections.min(integers));
	}
	
	//@Test
	public void HowtoFindaSublistinaListinJava() {
		System.out.println("-----Inside -----How to Find a Sublist in a List in Java?===========");
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // Find a sublist from index 2 to 6 (exclusive)
        List<Integer> sublist = numbers.subList(2, 7);
        
        // Print the original list and the sublist
        System.out.println("Original list: " + numbers);
        System.out.println("Sublist (from index 2 to 6): " + sublist);
	}
	
	@Test
	public void Howtoreplaceanelementinalist() {
		System.out.println("-----Inside -----How to replace an element in a list?===========");
		
		 List<String> fruits = new ArrayList<>();
	        fruits.add("Apple");
	        fruits.add("Banana");
	        fruits.add("Cherry");
	        fruits.add("Date");
	        
	        // Print the original list
	        System.out.println("Original list: " + fruits);
	        
	        // Replace "Banana" with "Grape"
	        int indexToReplace = 1; // Index of "Banana"
	        String newFruit = "Grape";
	        fruits.set(indexToReplace, newFruit);
	        
	        // Print the list after replacement
	        System.out.println("List after replacement: " + fruits);
	}
	
	@Test
	public void JavaProgramtoRotateElementsoftheList() {
		System.out.println("-----Inside -----Java Program to Rotate Elements of the List===========");
		List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        
        // Print original list
        System.out.println("Original list: " + numbers);
        
        // Rotate the list to the left by 2 positions
        rotateLeft(numbers, 2);
        
        // Print rotated list
        System.out.println("List after rotating left by 2 positions: " + numbers);
	}
	
	public static void rotateLeft(List<Integer> list, int positions) {
        int size = list.size();
        if (size == 0) return;
        
        // Reduce the number of rotations if positions > size
        positions %= size;
        
        // Rotate elements
        for (int i = 0; i < positions; i++) {
            int first = list.get(0);
            list.remove(0);
            list.add(first);
        }
    }

}

