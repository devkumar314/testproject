package POM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.Yaml;

public class TestClass {
	
	ExampleLoginPage loginPage;
	
	@DataProvider(name = "yamlData")
	public Object[][] getdata() throws FileNotFoundException{
		
		Yaml yaml = new Yaml();
		FileInputStream fis = new FileInputStream(Utils.getPath("/src/test/java/POM/TestClass.yaml"));
		List<Map<String,Object>> map = yaml.load(fis);
		Object[][] data = new Object[map.size()][2];
		
		for(int i=0; i< map.size(); i++) {
			Map<String,Object> val = map.get(i);
			data[i][0] = val.get("userName");
			data[i][1] = val.get("pass");
		}
		
		return data;
	}
	
	@Test(dataProvider="yamlData")
	public void login(String uName, String pass) {
		loginPage = new ExampleLoginPage();
		
		loginPage.navigateURL()
				.enterUserName(uName)
				.enterPassword(pass)
				.clickLogin();
		
		loginPage.close();
	}
	
	

}
