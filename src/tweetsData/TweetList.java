package tweetsData;

import java.util.ArrayList;

public class TweetList {
    private ArrayList<Tweet> tweets;

    /**
     * @return the tweets
     */
    public ArrayList<Tweet> getTweets() {
        return tweets;
    }

    /**
     * @param tweets the tweets to set
     */
    public void setTweets(ArrayList<Tweet> tweets) {
        this.tweets = tweets;
    }
    
     public void add(Tweet tweet) {
        this.tweets.add(tweet);
    }
    
    
}
