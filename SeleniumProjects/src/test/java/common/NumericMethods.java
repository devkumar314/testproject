package common;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class NumericMethods {
	
	int rev = 0;
	public int reverseNumber(int n) {
		
		int rem, rev = 0;
		
		while(n>0) {
			
			rem = n%10;
			n=n/10;
			rev = (rev*10)+rem;
		}
		
		return rev;
	}
	
	
	public int reverseNumberRecursive(int n) {
		
		if(n<=0){
			return rev;
		}
		int rem = n%10;
		rev = (rev*10)+rem;
		reverseNumberRecursive(n/10);
		return rev;
	}
		
}
