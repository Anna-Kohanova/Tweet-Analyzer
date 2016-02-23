package tweetsData;

public class Tweet {
    
    private String tweet;
    private Coordinates coordinates;
    private String date;    
  //  private Double emotionalColoring;
    
     public Tweet(String date, String coordinates, String tweet){
        this.tweet = tweet;
        this.coordinates = new Coordinates(coordinates);
        this.date = date;
     //   this.emotionalColoring = 0.0;
    }
    
    @Override
    public String toString() {
        return "Tweet:  " + date + "  " + coordinates.getX() + ", " + coordinates.getY() + "        " + tweet;
    }
}
