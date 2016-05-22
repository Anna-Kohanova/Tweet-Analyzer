package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import tweetsData.Coloring;
import tweetsData.Tweet;

public class QueryInsert {
    Connection connection;
    String query;
    
    public QueryInsert(Connection connection, String query)
    {
        this.connection = connection;
        this.query = query;
    }
    
    public void insertTweet(Tweet tweet, int id) throws ParseException
    {
        PreparedStatement preparedStatement = null;

        try {               
                
            java.sql.Date sqlDate = new java.sql.Date(tweet.getCl().getTime().getTime());
            
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1, tweet.getCoordinates().getX());
            preparedStatement.setDouble(2, tweet.getCoordinates().getY());
            preparedStatement.setString(3, tweet.getTweet());
            preparedStatement.setDate(4, sqlDate);

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void insertSentiment(Map.Entry<String, Double> map)
     {
         
         // TRUNCATE TABLE table_name 
         PreparedStatement preparedStatement = null;
         try {
             preparedStatement = connection.prepareStatement(query);
             preparedStatement.setString(1, map.getKey());
             preparedStatement.setDouble(2, map.getValue());
 
             preparedStatement.execute();
 
         } catch (SQLException e) {
             e.printStackTrace();
         }
     } 
    
    
}
