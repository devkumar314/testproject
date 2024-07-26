package tests.Utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.annotations.Test;

public class APITest {
	
	

		@Test
	    public static void GET_API_Test() {
	        try {
	            String url = "https://jsonplaceholder.typicode.com/posts";
	            HttpURLConnection httpClient = (HttpURLConnection) new URL(url).openConnection();

	            // Set request method to GET
	            httpClient.setRequestMethod("GET");

	            int responseCode = httpClient.getResponseCode();
	            System.out.println("GET Response Code: " + responseCode);

	            if (responseCode == HttpURLConnection.HTTP_OK) { // success
	                BufferedReader in = new BufferedReader(new InputStreamReader(httpClient.getInputStream()));
	                String inputLine;
	                StringBuffer response = new StringBuffer();

	                while ((inputLine = in.readLine()) != null) {
	                    response.append(inputLine);
	                }
	                in.close();

	                // Print result
	                System.out.println(response.toString());
	            } else {
	                System.out.println("GET request failed");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	
		
		@Test
		public static void Post_API_Test() {
	        try {
	            String url = "https://jsonplaceholder.typicode.com/posts";
	            HttpURLConnection httpClient = (HttpURLConnection) new URL(url).openConnection();

	            // Set request method to POST
	            httpClient.setRequestMethod("POST");
	            httpClient.setRequestProperty("Content-Type", "application/json; utf-8");
	            httpClient.setRequestProperty("Accept", "application/json");
	            httpClient.setDoOutput(true);

	            String jsonInputString = "{\"title\": \"foo\", \"body\": \"bar\", \"userId\": 1}";

	            try (OutputStream os = httpClient.getOutputStream()) {
	                byte[] input = jsonInputString.getBytes("utf-8");
	                os.write(input, 0, input.length);
	            }

	            int responseCode = httpClient.getResponseCode();
	            System.out.println("POST Response Code: " + responseCode);

	            if (responseCode == HttpURLConnection.HTTP_CREATED) { // success
	                BufferedReader in = new BufferedReader(new InputStreamReader(httpClient.getInputStream(), "utf-8"));
	                String inputLine;
	                StringBuffer response = new StringBuffer();

	                while ((inputLine = in.readLine()) != null) {
	                    response.append(inputLine.trim());
	                }
	                in.close();

	                // Print result
	                System.out.println(response.toString());
	            } else {
	                System.out.println("POST request failed");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

}
