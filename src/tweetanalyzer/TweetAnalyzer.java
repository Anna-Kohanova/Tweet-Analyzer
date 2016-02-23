/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tweetanalyzer;

import java.io.IOException;
import java.util.ArrayList;
import tweetsData.Tweet;

public class TweetAnalyzer {

    public static void main(String[] args) throws IOException {        
        
        int start = Integer.valueOf(args[0]);
        int amount = Integer.valueOf(args[1]);
        String fileName = args[2];

        Reader tweetsReader = new Reader(fileName);
        ArrayList<Tweet> tweets = tweetsReader.returnTweetsList();
        
        for(int i = start; i < start + amount; i++) {
            System.out.println(tweets.get(i).toString());
        }

//        for (Tweet tw : tweets) {
//            System.out.println(tw.toString());
//        }
    }

}
