package reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import parsers.StateParser;

public class StateReader {

    public ArrayList<Double> reader() throws FileNotFoundException, IOException {
        StateParser sp = new StateParser();

        File file = new File("states.json");
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();

        String str = new String(data, "UTF-8");
        return sp.parser(str);
    }
}
