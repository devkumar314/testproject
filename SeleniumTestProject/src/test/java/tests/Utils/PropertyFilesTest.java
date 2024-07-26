package tests.Utils;

import javax.xml.parsers.DocumentBuilderFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



public class PropertyFilesTest {

  public static void main(String[] args) throws IOException {
    
	  Properties prop = new Properties();
	  
	  FileInputStream fis = new FileInputStream("files/config.properties");
	  
	  prop.load(fis);
	  
	  String browser = prop.getProperty("browser");
	  String url = prop.getProperty("url");
	  
	  System.out.println("Properties Loaded -> Brower = " + browser);
	  System.out.println("Properties Loaded -> URL = " + url);
	  
  }
}

 
