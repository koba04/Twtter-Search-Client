
import java.util.List;

import twitter4j.*;

public class Twitter4J {

	/**
	 * @param args	search query
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Twitter twitter = new Twitter();
			QueryResult result = twitter.search(new Query(args[0]));
			List<Tweet> tweets = result.getTweets();
			
			for (Tweet tweet : tweets) {
				System.out.println("【" + tweet.getFromUser() + "】"
						+ tweet.getText());
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
