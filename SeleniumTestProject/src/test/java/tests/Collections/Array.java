package tests.Collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

import org.testng.annotations.Test;

public class Array {
	
	@Test
	public void arrayTest() {
		
		System.out.println("Arrays of Primitive");
		
		int[] ints = {7,5,6,8,9};
		
		Arrays.sort(ints);
		for(int i=0; i<ints.length; i++) {
			System.out.println(ints[i]);
		}
		
		
		System.out.println("Arrays of Strings");
		
		String[] strings = {"Red", "Green", "Blue"};
		
		Arrays.sort(strings);
		for(int i=0; i<strings.length; i++) {
			System.out.println(strings[i]);
		}
		
		
		System.out.println("Set initial Size");
		
		int[] sized = new int[10];
		
		for(int i=0; i<sized.length; i++) {
			sized[i] = i * 100;
		}
		
		for(int value : sized) {
			System.out.println(value);
		}
		
		
		System.out.println("Copy an array");
		
		int[] copied = new int[5];
		System.arraycopy(sized, 5, copied, 0, 5);
		for(int value : copied) {
			System.out.println(value);
		}
		
		
	}
	
	
	@Test
	public void multiDimentionalArrayTest() {
		
		String[][] states = new String[3][2];
		states[0][0] = "Cal";
		states[0][1] = "Screa";
		states[1][0] = "Arr";
		states[1][1] = "Bom";
		states[2][0] = "Xisis";
		states[2][1] = "Yiyiy";
		
		for(int i=0; i<states.length; i++) {
			
			StringBuilder sb = new StringBuilder();
			
			sb.append("The Capitol of")
			.append(states[i][0])
			.append(" is ")
			.append(states[i][1]);
		}
		
	}
	
	@Test
	public void findDuplicateInArray() {
		
		int[] array = {1, 2, 3, 4, 5, 3, 6, 7};
		findDuplicateUsingSorting(array);
		findDuplicateUsingHashMap(array);
		
	}
	
	@Test
	public void removeDuplicateInArray() {
		
		int[] array = {1, 2, 3, 4, 5, 3, 6, 7, 1, 2};
        int[] result = removeDuplicatesUsingSorting(array);
        System.out.println("Using Sorting: "+Arrays.toString(result));
        
        
        result = removeDuplicatesUsingMap(array);
        System.out.println("Using HashMap: "+Arrays.toString(result));
        
        result = IntStream.of(array).distinct().toArray();
        System.out.println("Using STream: "+Arrays.toString(result));
        
	}
	
	public static void findDuplicateUsingSorting(int[] array) {
        Arrays.sort(array);
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                System.out.println("Duplicate found: " + array[i]);
                return;
            }
        }
        System.out.println("No duplicates found.");
    }
	
	public static void findDuplicateUsingHashMap(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : array) {
            if (map.containsKey(num)) {
                System.out.println("Duplicate found: " + num);
                return;
            } else {
                map.put(num, 1);
            }
        }
        System.out.println("No duplicates found.");
    }
	
	public static int[] removeDuplicatesUsingSorting(int[] array) {
        Arrays.sort(array);
        int[] temp = new int[array.length];
        int j = 0;
        
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] != array[i + 1]) {
                temp[j++] = array[i];
            }
        }
        
        temp[j++] = array[array.length - 1];
        
        int[] uniqueArray = new int[j];
        System.arraycopy(temp, 0, uniqueArray, 0, j);
        return uniqueArray;
    }
	
	public static int[] removeDuplicatesUsingMap(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : array) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int[] uniqueArray = new int[map.size()];
        int index = 0;
        for (int num : map.keySet()) {
            uniqueArray[index++] = num;
        }
        return uniqueArray;
    }

}
