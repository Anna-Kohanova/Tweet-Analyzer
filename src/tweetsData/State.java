package tweetsData;

import java.util.ArrayList;

public class State {

    private ArrayList<Coordinates> coordinates;
    private String stateName;

    public State(ArrayList<Coordinates> coordinates, String stateName) {
        this.coordinates = coordinates;
        this.stateName = stateName;
    }

    public ArrayList<Coordinates> getCoordinates() {
        return coordinates;
    }

    public String getStateName() {
        return stateName;
    }

}
