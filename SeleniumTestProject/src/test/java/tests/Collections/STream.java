package tests.Collections;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class STream {
	
	
	//In Java, the Stream API, introduced in Java 8, 
	//is a powerful abstraction that allows for processing sequences of elements in a functional style. 
	//It is part of the java.util.stream package and provides methods for 
	//filtering, mapping, and reducing collections in a concise and readable manner.

	//Key Features of Streams
	//Functional Operations: 
	//Streams support operations such as filter, map, reduce, collect, and more, 
	//which can be chained together to form complex data processing pipelines.

	//Lazy Evaluation: 
	//Operations on a stream are performed lazily, meaning that they are not executed until a terminal operation 
	//(like collect or forEach) is invoked. This allows for optimizations and efficient processing.

	//Parallel Processing: 
	//Streams can be easily converted to parallel streams, allowing for parallel processing of data, 
	//which can improve performance for large datasets.

	//Immutability: 
	//Streams do not modify the underlying data structure; instead, 
	//they return new streams or results based on the applied operations.

	//Ease of Use: 
	//The API provides a concise and readable way to process collections compared to traditional loops and iterators.
	
	//Filtering and Collecting
	@Test
	public static void FilteringandCollecting() {
		System.out.println("==============FilteringandCollecting================");
		
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Edward");
        
        // Filter names starting with 'A' and collect them into a list
        List<String> filteredNames = names.stream()
                                          .filter(name -> name.startsWith("A"))
                                          .collect(Collectors.toList());
        
        System.out.println(filteredNames);  // Output: [Alice]
    }
	
	//Mapping and Reducing
	@Test
	public static void mappingAndReducing() {
		System.out.println("==============mappingAndReducing================");
		
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        
        // Map each number to its square and sum them up
        int sumOfSquares = numbers.stream()
                                  .map(number -> number * number)
                                  .reduce(0, Integer::sum);
        
        System.out.println(sumOfSquares);  // Output: 55
    }
	
	
	//Parallel Processing
	@Test
	public static void prallelProcessing() {
		System.out.println("==============prallelProcessing================");
		
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // Use parallel stream to process elements in parallel
        int sum = numbers.parallelStream()
                         .reduce(0, Integer::sum);
        
        System.out.println(sum);  // Output: 55
    }
	
	//Creating Streams -> From Collections
	@Test
	public static void CreatingStreamsFromCollections() {
		System.out.println("============CreatingStreamsFromCollections==================");
		
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        names.stream().forEach(System.out::println);
        names.forEach(System.out::println);
    }
	
	
	//Creating Streams -> From Arrays
	@Test
	public static void CreatingStreamsFromArrays() {
		System.out.println("=======CreatingStreamsFromArrays=======");
		
		String[] names = {"Alice", "Bob", "Charlie"};
        Stream.of(names).forEach(System.out::println);
    }
	

		//Creating Streams -> From Generator Functions
	@Test
	public static void CreatingStreamsFromGeneratorFunctions() {
		System.out.println("=======CreatingStreamsFromGeneratorFunctions=======");
		
		 Stream.iterate(0, n -> n + 2)
          .limit(10)
          .forEach(System.out::println);
    }
	
	@Test
	public static void StreamsTest()
    {
		System.out.println("=======StreamsTest=======");
		
        // create a list of integers
        List<Integer> number = Arrays.asList(2, 3, 4, 5); 

        // demonstration of map method
        List<Integer> square 
          = number.stream()
            .map(x -> x * x)
            .collect(Collectors.toList());

        // create a list of String
        List<String> names = Arrays.asList(
            "Reflection", "Collection", "Stream");

        // demonstration of filter method
        List<String> result
          = names.stream()
            .filter(s -> s.startsWith("S"))
            .collect(Collectors.toList());
      
        System.out.println(result);

        // demonstration of sorted method
        List<String> show 
          = names.stream()
            .sorted()
            .collect(Collectors.toList());
      
        System.out.println(show);

        // create a list of integers
        List<Integer> numbers
            = Arrays.asList(2, 3, 4, 5, 2);

        // collect method returns a set
        Set<Integer> squareSet
          = numbers.stream()
            .map(x -> x * x)
            .collect(Collectors.toSet());
      
        System.out.println(squareSet);

        // demonstration of forEach method
        number.stream()
            .map(x -> x * x)
            .forEach(y -> System.out.println(y));

        // demonstration of reduce method
        int even 
          = number.stream()
            .filter(x -> x % 2 == 0)
            .reduce(0, (ans, i) -> ans + i);

        System.out.println(even);
    }

}
