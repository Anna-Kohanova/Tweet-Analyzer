package reports;

import java.util.ArrayList;
import java.util.Map;
import tweetsData.State;
import tweetsData.Tweet;

public class ReportInfo {
    
    private ArrayList<Tweet> tweets;
    private ArrayList<State> states;
    private String firstDate;
    private String secondDate;
    private String tag;
    private Map<String, Double> coloring;
    
    public ReportInfo(ArrayList<Tweet> tweets, ArrayList<State> states, String firstDate, String secondDate, String tag, Map<String, Double> coloring) {
        this.tweets = tweets;
        this.states = states;
        this.firstDate = firstDate;
        this.secondDate = secondDate;
        this.tag = tag;
        this.coloring = coloring;
    }

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

    /**
     * @return the states
     */
    public ArrayList<State> getStates() {
        return states;
    }

    /**
     * @param states the states to set
     */
    public void setStates(ArrayList<State> states) {
        this.states = states;
    }

    /**
     * @return the firstDate
     */
    public String getFirstDate() {
        return firstDate;
    }

    /**
     * @param firstDate the firstDate to set
     */
    public void setFirstDate(String firstDate) {
        this.firstDate = firstDate;
    }

    /**
     * @return the secondDate
     */
    public String getSecondDate() {
        return secondDate;
    }

    /**
     * @param secondDate the secondDate to set
     */
    public void setSecondDate(String secondDate) {
        this.secondDate = secondDate;
    }

    /**
     * @return the tag
     */
    public String getTag() {
        return tag;
    }

    /**
     * @param tag the tag to set
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * @return the coloring
     */
    public Map<String, Double> getColoring() {
        return coloring;
    }

    /**
     * @param coloring the coloring to set
     */
    public void setColoring(Map<String, Double> coloring) {
        this.coloring = coloring;
    }
}


