package parsers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tweetsData.Tweet;

public final class TweetParser implements Parser<Tweet> {    
    
    private Pattern coordPattern;
    private Pattern datePattern;
    
    public TweetParser() {
        coordPattern = Pattern.compile("\\[[0-9\\-,\\s\\.]+\\]");
        datePattern = Pattern.compile("([0-9]{4}-[0-9]{2}-[0-9]{2})\\s([0-9]{2}:[0-9]{2}:[0-9]{2})");
    }

    @Override
    public Tweet parser(String line) {
        
        StringBuilder tweetText = new StringBuilder();
        tweetText.append(line);

         DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String coordinates = "";
        String str = tweetText.toString();

        Matcher coordinatesMatch = this.coordPattern.matcher(str);
        Matcher dateMatch = this.datePattern.matcher(str);

        if (dateMatch.find() && coordinatesMatch.find()) {
            coordinates = coordinatesMatch.group();
            
            try {
                date = format.parse(dateMatch.group());
            } catch (ParseException ex) {
                Logger.getLogger(TweetParser.class.getName()).log(Level.SEVERE, null, ex);
            }

            String tw = str.substring(dateMatch.end(), str.length());
        
            return new Tweet(date, coordinates, tw.trim());
        }
        return null;
        }    
}
