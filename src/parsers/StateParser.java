package parsers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tweetsData.State;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import tweetsData.Coordinates;

public final class StateParser implements Parser {

    @Override
    public ArrayList<Double> parser(String text) {

        JSONParser parser = new JSONParser();
        
        ArrayList<Double> coordinates = new ArrayList<Double>();
        
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
                
//                for (Object ob: msg) {
//                    System.out.println(ob); 
//                }
                
                for (Object d: coordinates) {
                    System.out.println(d); 
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return coordinates;
    }
}
