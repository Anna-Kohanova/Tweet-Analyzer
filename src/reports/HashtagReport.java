package reports;

import java.util.ArrayList;
import tweetsData.Tweet;

/**
 * Hashtag report
 * Finding tweets with given hashtag
 * @author Ania
 */

public class HashtagReport implements Reportable <ArrayList<Tweet>>{

    
    /**
     * Finding all tweets {@link Tweet} with given hashtag
     * 
     * @param info
     * @return ArrayList of Tweet objects
     */
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
