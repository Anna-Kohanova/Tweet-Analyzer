/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tweetanalyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tweetsData.Tweet;

public class Reader {

    private Pattern coordPattern;
    private Pattern datePattern;
    private File file;
    private BufferedReader reader;

    public Reader(String fileName) throws FileNotFoundException {
        
        this.file = new File(fileName);
        this.reader = new BufferedReader(new java.io.FileReader(this.file));
        
        coordPattern = Pattern.compile("\\[[0-9\\-,\\s\\.]+\\]");
        datePattern = Pattern.compile("([0-9]{4}-[0-9]{2}-[0-9]{2})\\s([0-9]{2}:[0-9]{2}:[0-9]{2})");
    }

    public ArrayList<Tweet> returnTweetsList() throws IOException {

        String line = "";
        StringBuilder tweet = new StringBuilder();
        ArrayList<Tweet> allTweets = new ArrayList<>();

        try {
        while ((line = reader.readLine()) != null) {
            tweet.append(line);
            
            String date = "";
            String coordinates = "";
            String str = tweet.toString();
            
            Matcher coordinatesMatch = this.coordPattern.matcher(str);
            Matcher dateMatch = this.datePattern.matcher(str);

            if (dateMatch.find() && coordinatesMatch.find()) {
                coordinates = coordinatesMatch.group();
                date = dateMatch.group();
                
                String tw = str.substring(dateMatch.end(), str.length());
                allTweets.add(new Tweet(date, coordinates, tw.trim()));
            }

            tweet.setLength(0);
        }
        reader.close();
        
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        return allTweets;
    }
}
