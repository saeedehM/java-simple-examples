package httpRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetPost {
	public static void main(String args[]) throws IOException{
		String url = "http://www.google.com/search?q=mkyong";
		try{
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();


		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		System.out.println(response.toString());
		}
		catch(Exception e){
			e.printStackTrace();
			return;
		}
	}

}
