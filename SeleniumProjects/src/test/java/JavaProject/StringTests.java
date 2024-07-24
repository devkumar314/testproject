package JavaProject;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import common.StringMethods;

public class StringTests {
	
	private String toBeReversed = "INDIA";
	
	private StringMethods stringMethods;

	@BeforeClass
	public void init() {
		stringMethods = new StringMethods();
	}
	
	@Test
	public void reverseStringTest() {
		
		String reverseString = stringMethods.reverseStringStandard(toBeReversed);
		System.out.println("Reverse String is: " + reverseString);
		reverseString = stringMethods.reverseStringStandard("123456789").toString();
		System.out.println("Reverse String is: " + reverseString);
		
	}
	
	@Test
	public void reverseStringCharAtTest() {
		
		String reverseString = stringMethods.reverseStringCharAt(toBeReversed);
		System.out.println("Reverse String is: " + reverseString);
		reverseString = stringMethods.reverseStringStandard("123456789").toString();
		System.out.println("Reverse String is: " + reverseString);
		
	}
	
	@Test
	public void checkAlphanumericStringTest() {
		String aString1 = "Alpha98";
		String aString2 = "Alphaio";
		
		Boolean isAlphanumeric = stringMethods.isStringAlphanumeric(aString1);
		Assert.assertTrue(isAlphanumeric, "The string is not alphanumeric : "+ aString1);
		
		isAlphanumeric = stringMethods.isStringAlphanumeric(aString2);
		Assert.assertFalse(isAlphanumeric, "The string is alphanumeric : "+ aString2);
		
		
		isAlphanumeric = stringMethods.isStringAlphanumericRegEx(aString1);
		Assert.assertTrue(isAlphanumeric, "The regex string is not alphanumeric : "+ aString1);
		
		isAlphanumeric = stringMethods.isStringAlphanumericRegEx(aString2);
		Assert.assertFalse(isAlphanumeric, "The regex string is alphanumeric : "+ aString2);
		
	}
	
	@Test
	public void checkPalingdromeStringTest() {
		String aString1 = "abba";
		String aString2 = "Alphaio";
		
		Boolean isPalingdrome = stringMethods.isPalingdrome(aString1);
		Assert.assertTrue(isPalingdrome, "The string is not Palingdrome : "+ aString1);
		
		isPalingdrome = stringMethods.isPalingdrome(aString2);
		Assert.assertFalse(isPalingdrome, "The string is Palingdrome : "+ aString2);
		
	}
	
	@Test
	public void checkSubStringTest() {
		String aString1 = "abbaTesabbatingabba";
		String subString1 = "abba";
		String subString2 = "ababa";
		
		Boolean isPresent = stringMethods.isSubStringPresent(aString1,subString1);
		Assert.assertTrue(isPresent, "The sub - string is not present : "+ aString1);
		
		isPresent = stringMethods.isSubStringPresent(aString1,subString2);
		Assert.assertFalse(isPresent, "The sub - string is not present : "+ aString1);
		
		
	}
	
	@Test
	public void checkOccuranceTest() {
		String source = "Here is an example. Right here.";
		String word = "here";
		int result = stringMethods.getOccurrences(source, word);
		System.out.println("result - " + result);
	}
	
	
}
