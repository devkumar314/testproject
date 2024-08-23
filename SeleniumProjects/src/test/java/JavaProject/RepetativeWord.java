package JavaProject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RepetativeWord {

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
    }

    private static Map<String, Integer> countWordOccurrences(String sentence) {
        // Convert the sentence to lowercase and split it into words
        String[] words = sentence.toLowerCase().split("\\s+");

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
}
