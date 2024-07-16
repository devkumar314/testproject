package JavaProject;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import common.NumericMethods;

public class NumberTests {
	
	private String toBeReversed = "INDIA";
	
	private NumericMethods numericMethods;

	@BeforeClass
	public void init() {
		numericMethods = new NumericMethods();
	}
	
	@Test
	public void reverseNumberTest() {
		
		int actNumber = 12345;
		int reverseString = numericMethods.reverseNumber(actNumber);
		System.out.println("Reverse numeric is:  " + reverseString);
		
		int reverseString2 = numericMethods.reverseNumberRecursive(actNumber);
		System.out.println("Reverse numeric using recursive is:  " + reverseString2);
		
	}
		
}
