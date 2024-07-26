package tests.Utils;

import org.testng.annotations.Test;

import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class TXTReaderTest {

	static String filePath = "files/txtfile.txt";

    @Test()
    public static void BufferedReaderTest() {
    	
    	System.out.println("=============BufferedReader============");
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test()
    public static void ScannerTest() {
    	
    	System.out.println("=============ScannerTest============");
    	
    	
        
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    @Test()
    public static void FilesTest() {
    	System.out.println("=============FilesTest============");
    	
    	
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Test()
    public static void FilesLinesTest() {
    	
    	System.out.println("=============FilesLinesTest============");
    	
    	
    	
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            stream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    @Test
    public static void ReadBinaryFile() throws IOException {
    	System.out.println("==========ReadBinaryFile=======================");
    	
        FileInputStream inputStream = null;
        try {
          // Replace "filename.bin" with your actual file path
          inputStream = new FileInputStream(filePath);

          int a;
          while ((a = inputStream.read()) != -1) {
            System.out.println(a); // Print each byte as an integer
          }

        } finally {
          if (inputStream != null) {
            inputStream.close();
          }
        }
      }
    
    
}
