package JavaProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class RepetativeChar {

    public static void main(String[] args) {
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user for input
        System.out.println("Enter a sentence:");
        String sentence = scanner.nextLine();
        
        // Close the scanner
        scanner.close();
        
        // Call the method to count word occurrences
        Map<String, Integer> wordCount = countWordOccurrences(sentence);
        
        // Print the result
        System.out.println("Word occurrences:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        Integer thirdMax = findThirdMaximum(wordCount);

        // Print the result
        if (thirdMax != null) {
            System.out.println("The third maximum value is: " + thirdMax);
        } else {
            System.out.println("Not enough unique values to find the third maximum.");
        }
        
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            // Check if the current value matches the target value
            if (entry.getValue() == thirdMax) {
            	System.out.println("The third maximum key is: " + entry.getKey());
                
            }
        }
    }

    private static Map<String, Integer> countWordOccurrences(String sentence) {
        // Convert the sentence to lowercase and split it into words
        String[] words = sentence.toLowerCase().split("");

        // Create a map to store word counts
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Iterate through each word
        for (String word : words) {
            // If the word is already in the map, increment its count
            if (wordCountMap.containsKey(word)) {
                wordCountMap.put(word, wordCountMap.get(word) + 1);
            } else {
                // Otherwise, add the word to the map with a count of 1
                wordCountMap.put(word, 1);
            }
        }

        return wordCountMap;
    }
    
    private static Integer findThirdMaximum(Map<String, Integer> map) {
        // Extract values from the map
        List<Integer> values = new ArrayList<>(map.values());

        // Remove duplicates if any
        Set<Integer> uniqueValues = new TreeSet<>(Collections.reverseOrder());
        uniqueValues.addAll(values);

        // Convert the sorted set to a list
        List<Integer> sortedValues = new ArrayList<>(uniqueValues);

        // Check if there are at least 3 unique values
        if (sortedValues.size() < 3) {
            return null; // Not enough unique values
        }

        // Return the third maximum value
        return sortedValues.get(2);
    }
}
