package database;

import java.text.ParseException;
import java.util.Map;
import tweetsData.TweetColoringList;
import tweetsData.TweetList;

public class DBWorker {

    final String INSERT_TWEET = "INSERT INTO all_tweets VALUES(?, ?, ?, ?)";
    final String INSERT_SENTIMENT = "INSERT INTO coloring VALUES(?, ?)";

    final String GET_TWEET = "SELECT * FROM all_tweets";
    final String GET_COLORING = "SELECT * FROM coloring";
    final String GET_WHERE_HASHTAG = "SELECT * FROM all_tweets WHERE tweet LIKE";

    public void insertTweets(DBConnection dbConnection, TweetList tweetList) throws ParseException {
        QueryInsert queryExecution = new QueryInsert(dbConnection.getConnection(), INSERT_TWEET);

        for (int i = 0; i < tweetList.getTweets().size(); i++) {
            queryExecution.insertTweet(tweetList.getTweets().get(i), i + 1);
        }
    }

    public TweetList getAllTweets(DBConnection dbConnection) {
        QueryGet queryGet = new QueryGet(dbConnection.getConnection(), GET_TWEET);
        
        return queryGet.getAllTweets();
    }
    
    public TweetColoringList getAllColoring(DBConnection dbConnection) {
        QueryGet queryGet = new QueryGet(dbConnection.getConnection(), GET_COLORING);
        
        return queryGet.getAllColorings();
    }
    
    public void insertSentiments(DBConnection dbConnection, Map<String, Double> tweetColoring) throws ParseException {
        QueryInsert queryExecution = new QueryInsert(dbConnection.getConnection(), INSERT_SENTIMENT);
        
        for (Map.Entry<String, Double> map: tweetColoring.entrySet()) {
            queryExecution.insertSentiment(map);
        }
    }
    
    

    public TweetList getTweetsWithHashtag(DBConnection dbConnection, String hashtag) {
        QueryGet queryGet = new QueryGet(dbConnection.getConnection(), GET_WHERE_HASHTAG + hashtag);

        return queryGet.getAllTweets();
    }

}
