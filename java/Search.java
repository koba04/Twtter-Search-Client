import java.io.*;
import java.net.*;
import java.util.List;

import org.json.simple.*;

public class Search {

	/**
	 * @param args	search query
	 */
	public static void main(String[] args) {

		try {
			// URIの組立て
			String query = URLEncoder.encode(args[0], "UTF-8");
			String api = "http://search.twitter.com/search.json?q=" + query;
			URL uri = new URL(api);

			// HTTP Request
			HttpURLConnection request = (HttpURLConnection) uri.openConnection();
			request.setRequestMethod("GET");
			BufferedReader response = new BufferedReader(new InputStreamReader(
					request.getInputStream()));

			// Response Parse
			StringBuilder responseBody = new StringBuilder();
			String str;
			while ((str = response.readLine()) != null) {
				responseBody.append(str);
			}
			response.close();
			request.disconnect();
			
			JSONObject json = (JSONObject) JSONValue.parse(responseBody.toString());
			List<JSONObject> tweets = (List<JSONObject>) json.get("results");
			
			System.out.println("Parse is =>" + tweets.toString());
			
			for (JSONObject tweet : tweets) {
				System.out.println("【" + tweet.get("from_user") + "】"
						+ tweet.get("text"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
