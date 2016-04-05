package reports;

import java.util.ArrayList;
import tweetsData.Tweet;

public class HashtagReport implements Reportable <ArrayList<Tweet>>{

    @Override
    public ArrayList<Tweet> getReportResult(ReportInfo info) {
        ArrayList<Tweet> selectedTweets = new ArrayList<Tweet>();
        
        for (Tweet tweet : info.getTweets()) {
            if ((tweet).getTweet().contains(info.getTag())) {
                selectedTweets.add(tweet);
            }
        }       
        
        return selectedTweets;
    }   
    
}
