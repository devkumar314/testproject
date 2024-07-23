package tests.Collections;

import java.util.Arrays;

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

}
