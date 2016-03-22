package reports;

import java.util.ArrayList;
import tweetsData.Tweet;

public class HashtagReport implements Reportable <ArrayList<Tweet>>{
    private ArrayList<Tweet> tweets;
    private String tag;
    
    public HashtagReport(ArrayList<Tweet> tweets, String tag) {
        this.tweets = tweets;
        this.tag = tag;
    }

    @Override
    public ArrayList<Tweet> getReportResult() {
        ArrayList<Tweet> selectedTweets = new ArrayList<Tweet>();
        
        for (Tweet tweet : tweets) {
            if ((tweet).getTweet().contains(tag)) {
                selectedTweets.add(tweet);
            }
        }       
        
        return selectedTweets;
    }
    
    
}
