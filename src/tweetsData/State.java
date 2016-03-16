package tweetsData;

import java.util.ArrayList;

public class State {

    private ArrayList<Object> coordinates;
    private String stateName;

    public State(ArrayList<Object> coordinates, String stateName) {
        this.coordinates = coordinates;
        this.stateName = stateName;
    }

    public ArrayList<Object> getCoordinates() {
        return coordinates;
    }

    public String getStateName() {
        return stateName;
    }

}
