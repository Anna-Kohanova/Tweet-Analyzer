package reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import parsers.ColoringParser;
import parsers.Parser;
import parsers.StateParser;
import tweetsData.State;

public class StateReader {
    
    public ArrayList<State> reader() throws FileNotFoundException, IOException {
        Parser<ArrayList<State>> sp = new StateParser();

        File file = new File("states.json");
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();

        String str = new String(data, "UTF-8");
        return sp.parser(str);
    }
}
