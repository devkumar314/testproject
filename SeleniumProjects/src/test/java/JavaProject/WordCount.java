package JavaProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class WordCount {

	public static void main(String[] args) {
		
		final int FIRST_LARGEST = 1;
		final int SECOND_LARGEST = 2;
		final int THIRD_LARGEST = 3;
		
		Scanner sc = new Scanner(System.in);
		String sentence = sc.nextLine().toLowerCase();
		sc.close();
		
		Map<String, Integer> map = findRepWordMap(sentence); 
		
		for(String entry : map.keySet()) {
			System.out.println(entry + map.get(entry));
		}
		
		int num = findNLargetsNumber(map, FIRST_LARGEST);
		System.out.println(num);
		
		for(String entry : map.keySet()) {
			if(map.get(entry) == num) {
				System.out.println("Larget number is : " + entry + map.get(entry));
			}
		}		
	}
	
	private static Map<String, Integer> findRepWordMap(String sentence){
		
		Map<String, Integer> map = new HashMap<>();
		String[] arr = sentence.split("");
		
		for(String ch : arr) {
			if(map.containsKey(ch)) 
				map.put(ch, map.get(ch) + 1);
			else 
				map.put(ch, 1);
		}		
		return map;
	}
	
	private static Integer findNLargetsNumber(Map<String, Integer> map, int N) {
		
		List<Integer> arrList = new ArrayList<> (map.values());
		System.out.println("Not Sorted: " + arrList);
		
		Set<Integer> unique = new TreeSet<>(Collections.reverseOrder());
		unique.addAll(arrList);
		
		List<Integer> sortedVal = new ArrayList<> (unique);
		//List<Integer> sortedVal1=  unique.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
		
		if (sortedVal.size() < N) {
            return null; // Not enough unique values
        }
		
		System.out.println("Sorted: " + sortedVal);
		return sortedVal.get(N-1);
	}
}
