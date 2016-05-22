package tweetanalyzer;

import database.DBConnection;
import database.DBWorker;
import java.awt.Polygon;
import reader.TweetReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;
import polygons.AppFrame;
import polygons.Polygons;
import reader.ColoringReader;
import reader.StateReader;
import reports.ColoringReport;
import reports.HashtagReport;
import reports.ReportInfo;
import reports.StatesReport;
import tweetsData.Coloring;
import tweetsData.State;
import tweetsData.Tweet;

import java.sql.*;
import reports.Sort;
import threads.ClReader;
import threads.FirstReport;
import threads.SecondReport;
import threads.StReader;
import threads.ThirdReport;
import threads.TwReader;
import tweetsData.TweetColoringList;
import tweetsData.TweetList;

public class TweetAnalyzer {

    public static void main(String[] args) throws IOException, ParseException, ClassNotFoundException, SQLException, InterruptedException {
        
        DBConnection dbConnection = new DBConnection(); 
        dbConnection.isConnected();
                
        // Command line parameters
//        int start = Integer.valueOf(args[0]);
//        int amount = Integer.valueOf(args[1]);
        String fileName = args[2];

        
        
        
//        TweetReader tweetsReader = new TweetReader(fileName);
//        ArrayList<Tweet> tweets = tweetsReader.returnTweetsList();
        
        TwReader tweetsReader = new TwReader();
        tweetsReader.run();
        tweetsReader.join();
        ArrayList<Tweet> tweets = tweetsReader.getTweets();
        
        TweetList tweetList = new TweetList();
        tweetList.setTweets(tweets); 
        
//         for (Tweet st : tweets) {
//            System.out.println(st.getTweet());
//        }       
        
        
        
//        ColoringReader coloringReader = new ColoringReader();
        ClReader clReader = new ClReader();
        clReader.run();
        clReader.join();     
        Coloring.setColoring(clReader.getHt());    
        Map<String, Double> coloring = Coloring.getColoring();
        
//        for (Map.Entry<String, Double> map: coloring.entrySet()) {
//            System.out.println("Weight : " + map.getValue() + "   " + map.getKey());
//        }    
        
        
        

//        StateReader stateReader = new StateReader();
//        ArrayList<State> states = stateReader.reader();
        
        StReader stReader = new StReader();
        stReader.run();
        stReader.join();
        ArrayList<State> states = stReader.getStates();
        
     
        
        String firstDate = "2011-08-28 18:35:06";
        String secondDate = "2011-08-30 20:04:46";            
        String tag = "#Winning";
        
        ReportInfo info = new ReportInfo(tweets, states, firstDate, secondDate, tag, coloring);
        
        

//        HashtagReport tagReport = new HashtagReport();
//        ArrayList<Tweet> selectedTweets = tagReport.getReportResult(info);
        
        FirstReport firstReport = new FirstReport(info);
        firstReport.start();
        firstReport.join();
        ArrayList<Tweet> selectedTweets = firstReport.getSelectedTweets();      
        
//         for (Tweet st : selectedTweets) {
//            System.out.println(st.getTweet());
//        }
        
        
        
//        StatesReport statesReport = new StatesReport();
//        String state = statesReport.getReportResult(info);
                
        SecondReport secondReport = new SecondReport(info);
        secondReport.start();
        secondReport.join();
        String state = secondReport.getResultState();
      //  System.out.println(state);
           
        
        
        
        ThirdReport thirdReport = new ThirdReport(info);
        thirdReport.run();
        thirdReport.join();
        Map<String, Double> tweetColoring = thirdReport.getTweetColoring();
      
//        for (Map.Entry<String, Double> map: tweetColoring.entrySet()) {
//            System.out.println("Weight : " + map.getValue() + "   " + map.getKey());
//        }
            
        
        
        
        
        DBWorker dbWorker = new DBWorker();
       // dbWorker.insertTweets(dbConnection, tweetList);
       // dbWorker.insertSentiments(dbConnection, coloring);
        
        TweetList tl = dbWorker.getAllTweets(dbConnection); 
        TweetColoringList coloringList = dbWorker.getAllColoring(dbConnection);
        TweetList tweetsInInterval = dbWorker.getTweetsInInterval(dbConnection);
      //  TweetList tl = dbWorker.getTweetsWithHashtag(dbConnection, "'%winning%'");
        
        
//        for (Tweet tw : tweetsInInterval.getTweets()) {
//            System.out.println(tw.getTweet());
//        }
        
//        for (Map.Entry<String, Double> map: coloringList.getHt().entrySet()) {
//            System.out.println("Weight : " + map.getValue() + "   " + map.getKey());
//        }     
        
      
        
        // Draw map of the states
        //ArrayList<Polygon> polygonList = Polygons.getPolygons(states);        
       // new AppFrame().draw(polygonList);
    }
}
