package tweetanalyzer;

import reader.TweetReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import reader.ColoringReader;
import reader.StateReader;
import tweetsData.Coloring;
import tweetsData.State;
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

//        for (Map.Entry entry : coloring.entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }

        StateReader stateReader = new StateReader();
        ArrayList<State> states = stateReader.reader();

//        for (State state: states) {
//            System.out.println(state.getStateName());
//        }

        for (int i = start; i < start + amount; i++) {
            System.out.println(tweets.get(i).toString());
        }
    }
}
