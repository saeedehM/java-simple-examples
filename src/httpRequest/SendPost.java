package httpRequest;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class SendPost {
	public static void main(String args[]) throws Exception{
		String urlParameters = "name=Saeedeh&occupation=student";
        byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
        String url = "http://example.com";
        try{
        	URL obj= new URL(url);
    		HttpURLConnection con= (HttpURLConnection) obj.openConnection();
    		con.setDoOutput(true);
    		con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.write(postData);
            }
            
        	int responseCode= con.getResponseCode();
    		System.out.println("\nSending 'POST' request to URL : ");
    		System.out.println("Post parameters : "+postData);
    		System.out.println("Response Code : "+responseCode);
    		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    		String inputLine;
    		StringBuffer response = new StringBuffer();
    		
    		while((inputLine=in.readLine())!=null) {
    			response.append(inputLine);
    		}
    		in.close();
    		System.out.println(response.toString());
    		con.disconnect();
        }
        catch(Exception e){
        	e.printStackTrace();
        	return;
        }
	}
}
		
		
	

