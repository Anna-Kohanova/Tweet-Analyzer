package tweetanalyzer;

import reader.TweetReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import reader.ColoringReader;
import reader.StateReader;
import tweetsData.Coloring;
import tweetsData.Tweet;

public class TweetAnalyzer {

    public static void main(String[] args) throws IOException {        
        
        // Command line parameters
        int start = Integer.valueOf(args[0]);
        int amount = Integer.valueOf(args[1]);
        String fileName = args[2];        

        TweetReader tweetsReader = new TweetReader(fileName);        
        ArrayList<Tweet> tweets = tweetsReader.returnTweetsList(); 
        
        ColoringReader coloringReader = new ColoringReader();
        Coloring.setColoring(coloringReader.returnColoringHashMap());  
        Map<String, Double> coloring = Coloring.getColoring();
        
        StateReader stateReader = new StateReader();
        ArrayList<Double> coordinates = stateReader.reader();
        
        
        for(int i = start; i < start + amount; i++) {
            System.out.println(tweets.get(i).toString());
        }
    }
}
