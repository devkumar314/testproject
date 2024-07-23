package common;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringMethods {

	public String reverseStringStandard(String value) {
		String[] arrVal = value.split("");
		arrVal = reverse(arrVal);
		
		String s="";
		for (int k = 0; k < arrVal.length; k++) { 
            s = String.join("", s, arrVal[k]); 
        } 
		return s;
	}
	
	public String reverseStringCharAt(String value) {
		
		String ch = "";
		for (int k = 0; k < value.length(); k++) { 
            
			ch = ch + value.charAt(value.length()-k-1);
			System.out.println(ch); 
        } 
		
		return ch;
	}
	
	public Boolean isStringAlphanumeric(String value) {
		
		return value.matches("^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9]+$");
		
	}
	
	public Boolean isStringAlphanumericRegEx(String value) {
		
		String regEx = "^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9]+$";
		
		 if (value == null) {
	            return false;
	        }
		 
		Pattern p = Pattern.compile(regEx);
		
		Matcher m = p.matcher(value);
		return m.matches();
		
	}
	
	
	public Boolean isPalingdrome(String value) {
		String[] arrVal = value.split("");
		arrVal = reverse(arrVal);
		
		String s="";
		for (int k = 0; k < arrVal.length; k++) { 
            s = String.join("", s, arrVal[k]); 
        } 
		
		return s.equals(value);
	}
	
	public int getOccurrences(String source, String word) {
		
		int loc = 0;
        int count=0;

        while(source.indexOf(source, loc)>=0){
            int loc1 = source.indexOf(source, loc);
            if(loc1>=0){
                count=count+1;
                loc = loc1+1;
            }
        }
        return count;
        

	}
	
	public Boolean isSubStringPresent(String str, String subString1) {
		
		 if (str == null) {
	            return false;
	        }
		 
		Pattern p = Pattern.compile(subString1);
		
		Matcher matcher = p.matcher(str);
		int count = 0;
		
		while (matcher.find()) { 
            int start = matcher.start(); 
            int end = matcher.end(); 
            String match = str.substring(start, end); 
            System.out.println("Found word \"" + match 
                               + "\" at index [" + start 
                               + ", " + (end - 1) + "]"); 
            count++;
        }
		System.out.println("Number of occurrences using regex: " + count);
		
		return ((count>=1)?true:false);
	}
	
	static String[] reverse(String[] a) {
		
		String[] b = new String[a.length];
		
		for(int i=a.length; i>0; i--) {
			b[a.length-i] = a[i-1];
		}
		
		// printing the reversed array 
        System.out.println("Reversed array is: \n"); 
		
        for (int k = 0; k < a.length; k++) { 
            System.out.println(b[k]); 
        } 
        
		return b;
		
	}

	
}
