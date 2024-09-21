package POM;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	
	public Properties prop;
	WebDriver driver;
	
	public WebDriver initDriver() {
		initProperties();
		
		String browser = getProperty("browser");
		
		switch(browser){
			case "chrome":
				System.setProperty("webdriver.chrome.driver", Utils.getPath("/src/test/resources/drivers/chromedriver.exe"));
				driver = new ChromeDriver();
		}
		
		return driver;
	}
	
	public void initProperties() {
		
		try {
			FileInputStream fis = new FileInputStream(new File(Utils.getPath("/files/config.properties")));
			prop = new Properties();
			prop.load(fis);
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getProperty(String propertyName) {
		return prop.getProperty(propertyName);
	}

}
