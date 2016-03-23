package tweetanalyzer;

import reader.TweetReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;
import reader.ColoringReader;
import reader.StateReader;
import reports.ColoringReport;
import reports.HashtagReport;
import tweetsData.Coloring;
import tweetsData.State;
import tweetsData.Tweet;

public class TweetAnalyzer {

    public static void main(String[] args) throws IOException, ParseException {

        // Command line parameters
//        int start = Integer.valueOf(args[0]);
//        int amount = Integer.valueOf(args[1]);
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

//        StatesReport statesReport = new StatesReport();
//        statesReport.getReportResult();
        String firstDate = "2011-08-28 18:35:06";
        String secondDate = "2011-08-28 20:04:46";

        ColoringReport coloringReport = new ColoringReport(coloring, tweets, firstDate, secondDate);
        Map<String, Double> tweetColoring = coloringReport.getReportResult();

        // Output for checking the second report
//        for (Map.Entry<String, Double> map: tweetColoring.entrySet()) {
//            System.out.println("Weight : " + map.getValue() + "   " + map.getKey());
//        }
        
        // Output for checking the 1st report
//        for (Tweet tw : selectedTweets) {
//            System.out.println(tw.getTweet());
//        }
    }
}
