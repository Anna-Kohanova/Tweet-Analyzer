package parsers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import tweetsData.State;

public final class StateParser implements Parser <ArrayList<State>>{

    @Override
    public ArrayList<State> parser(String text) {

        JSONParser parser = new JSONParser();
        ArrayList<State> states = new ArrayList<State>();        
        ArrayList<Object> coordinates = new ArrayList<Object>();
        
        try {

            Object obj = parser.parse(text);

            JSONObject jsonObject = (JSONObject) obj;

            Pattern pattern = Pattern.compile("[A-Z]+");
            Matcher matcher = pattern.matcher(text);

            String state;
            while (matcher.find()) {
                state = matcher.group();
                
                JSONArray msg = (JSONArray) jsonObject.get(state);
                Iterator<Double> iterator = msg.iterator();
                
                while(iterator.hasNext()) {
                    coordinates.add(iterator.next());
                }
                
                states.add(new State(coordinates, state));
                
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return states;
    }
}
