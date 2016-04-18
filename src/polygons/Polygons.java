package polygons;

import java.awt.Polygon;
import java.util.ArrayList;
import tweetsData.Coordinates;
import tweetsData.State;

public final class Polygons {

    public static Boolean isInside(Coordinates coordinate, State state) {
        
        Polygon polygon = new Polygon();

        for(int i = 0; i<state.getCoordinates().size(); i++){

            for(int g = 0; g<state.getCoordinates().get(i).size(); g++){

                int x = state.getCoordinates().get(i).get(g).getX(1000000);
                int y = state.getCoordinates().get(i).get(g).getY(1000000);

                polygon.addPoint(x,y);
            }

            int x = coordinate.getX(1000000);
            int y = coordinate.getY(1000000);

            if(polygon.contains(y,x)){
                return true;
            }

        }
        return false;
    }
    
    public static ArrayList<Polygon> getPolygons(ArrayList<State> states){

        ArrayList<Polygon> polygons = new ArrayList<>();

            for(State state : states) {

                for (int i = 0; i < state.getCoordinates().size(); i++) {

                    Polygon polygon = new Polygon();
                    
                    for (int j = 0; j < state.getCoordinates().get(i).size(); j++) {

                        int x = state.getCoordinates().get(i).get(j).getX(1000000);
                        int y = state.getCoordinates().get(i).get(j).getY(1000000);
                        
                        polygon.addPoint(x / 100000 + 1500, -y / 100000 + 800);
                    }                    
                    polygons.add(polygon);
                }
            }
        return polygons;
    }
}
