package threads;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import reader.StateReader;
import reader.TweetReader;
import tweetsData.Tweet;

public class TwReader extends Thread {
    
    private ArrayList<Tweet> tweets;
    
    public TwReader() {
        
    }
    
     public void run(){
        try {
            TweetReader tweetReader = new TweetReader("text.txt");
            try {
                this.tweets = tweetReader.returnTweetsList();
            } catch (IOException ex) {
                Logger.getLogger(TwReader.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TwReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the states
     */
    public ArrayList<Tweet> getTweets() {
        return tweets;
    }
}
