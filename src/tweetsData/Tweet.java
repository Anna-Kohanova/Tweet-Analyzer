package tweetsData;

import java.util.Calendar;
import java.util.Date;

public class Tweet {
    
    private String tweet; 
    private Coordinates coordinates;
    private Date date;  
    private Calendar cl;
    private Double emotionalColoring;
    private Double X;
    private Double Y;
    
    
     public Tweet(Date date, String coordinates, Calendar cl, String tweet){
        this.tweet = tweet;
        this.coordinates = new Coordinates(coordinates);
        this.date = date;
        this.cl = cl;
        this.emotionalColoring = 0.0;
    }
     
      public Tweet(Date date, Coordinates coord, String tweet){
        this.tweet = tweet;
        this.coordinates = coord;
        this.date = date;
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

    /**
     * @return the cl
     */
    public Calendar getCl() {
        return cl;
    }
}
