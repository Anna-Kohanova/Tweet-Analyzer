package reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import parsers.TweetParser;
import tweetsData.Tweet;

public class TweetReader {

    private File file;
    private BufferedReader reader;

    public TweetReader(String fileName) throws FileNotFoundException {

        this.file = new File(fileName);
        this.reader = new BufferedReader(new java.io.FileReader(this.file));
    }

    public ArrayList<Tweet> returnTweetsList() throws IOException {

        String line = "";
        ArrayList<Tweet> allTweets = new ArrayList<>();
        TweetParser parser = new TweetParser();

        try {
            while ((line = reader.readLine()) != null) {
                allTweets.add(parser.parser(line));
            }
            reader.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return allTweets;
    }
}
