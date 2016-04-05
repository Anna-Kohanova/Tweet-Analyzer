package polygons;

import java.awt.Polygon;
import java.util.ArrayList;
import tweetsData.Coordinates;
import tweetsData.State;
import tweetsData.Tweet;

public class Polygons {

    public static Boolean isInside(Tweet tweet, State state) {

        for (ArrayList<Coordinates> coordState : state.getCoordinates()) {

            Polygon polygon = new Polygon();

            for (Coordinates coord : coordState) {
                polygon.addPoint(coord.getX(), coord.getY());
            }
            
            int x = tweet.getCoordinates().getX();
            int y = tweet.getCoordinates().getY();

            if (polygon.contains(y, x)) {
                return true;
            }
        }

        return false;
    }
}
