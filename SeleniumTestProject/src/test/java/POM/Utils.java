package POM;

public class Utils {
	
	public static String getPath(String path) {
		String rPath = System.getProperty("user.dir");
		System.out.println(rPath + path);
		return rPath + path;
	}
	
	

}
