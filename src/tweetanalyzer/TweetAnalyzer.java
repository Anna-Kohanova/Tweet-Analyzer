package tweetanalyzer;

import reader.TweetReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import reader.ColoringReader;
import reader.StateReader;
import reports.HashtagReport;
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

        StateReader stateReader = new StateReader();
        ArrayList<State> states = stateReader.reader();

        HashtagReport tagReport = new HashtagReport(tweets, "#Winning");
        ArrayList<Tweet> selectedTweets = tagReport.getReportResult();

        // Output for checking the 1st report
//        for (Tweet tw : selectedTweets) {
//            System.out.println(tw.getTweet());
//        }
    }
}
