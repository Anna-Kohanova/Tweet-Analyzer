package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import tweetsData.Coordinates;
import tweetsData.Tweet;
import tweetsData.TweetColoringList;
import tweetsData.TweetList;

public class QueryGet {

    Connection connection;
    String query;

    public QueryGet(Connection connection, String query) {
        this.connection = connection;
        this.query = query;
    }

    public QueryGet(Connection connection) {
        this.connection = connection;
    }
    
    public TweetList getAllTweets()
    {
        TweetList tweetList = new TweetList();
        ArrayList<Tweet> tweets = new ArrayList<Tweet>();
        PreparedStatement preparedStatement = null;

        try {
            
            preparedStatement = connection.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery();
            

            while(result.next())
            {
                Coordinates tweetLocation = new Coordinates(result.getDouble("X"), result.getDouble("Y"));
                tweets.add(new Tweet(result.getDate("date"), tweetLocation, result.getString("tweet")));                
            }
            
            tweetList.setTweets(tweets);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tweetList;
    }
    
     public TweetColoringList getAllColorings()
    {
        Map<String, Double> ht = new HashMap<String, Double>();
        TweetColoringList coloring = new TweetColoringList();
        
        PreparedStatement preparedStatement = null;

        try {
            
            preparedStatement = connection.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery();
            

            while(result.next())
            {
                ht.put(result.getString("key"), result.getDouble("value"));        
            }
            
            coloring.setHt(ht);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return coloring;
    }
     
     

}
    


