package parsers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import tweetsData.Coordinates;
import tweetsData.State;

public final class StateParser implements Parser<ArrayList<State>> {

    public ArrayList<State> parser(String text) {

        JSONParser parser = new JSONParser();
        ArrayList<State> states = new ArrayList<State>();

        try {

            Object obj = parser.parse(text);
            JSONObject jsonObject = (JSONObject) obj;

            Pattern pattern = Pattern.compile("[A-Z]+");
            Matcher matcher = pattern.matcher(text);

            String state = "";
            while (matcher.find()) {
                
                ArrayList<ArrayList<Coordinates>> coord = new ArrayList<>();                
                ArrayList<Coordinates> stateCoordinates = new ArrayList<>();
                state = matcher.group();

                JSONArray msg = (JSONArray) jsonObject.get(state);

                for (Object object : msg) {
                    Pattern pattern1 = Pattern.compile("\\[([^\\[]+)\\]");
                    Matcher matcher1 = pattern1.matcher(object.toString());          
                     

                    while (matcher1.find()) {
                        stateCoordinates.add(new Coordinates(matcher1.group()));
                    }
                    coord.add(stateCoordinates);
                }

                states.add(new State(coord, state));

            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return states;
    }
}
