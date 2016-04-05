package tweetsData;

import java.util.Date;

public class Tweet {
    
    private String tweet; 
    private Coordinates coordinates;
    private Date date;  
    private Double emotionalColoring;
    
     public Tweet(Date date, String coordinates, String tweet){
        this.tweet = tweet;
        this.coordinates = new Coordinates(coordinates);
        this.date = date;
        this.emotionalColoring = 0.0;
    }
    
    @Override
    public String toString() {
        return "Tweet:  " + getDate() + "  " + getCoordinates().getX() + ", " + getCoordinates().getY() + "        " + getTweet();
    }

    public String getTweet() {
        return tweet;
    }

    public Date getDate() {
        return date;
    }

    /**
     * @return the coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }
}
