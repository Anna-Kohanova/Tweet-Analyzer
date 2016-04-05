package reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import parsers.ColoringParser;
import parsers.Parser;

public class ColoringReader {
    private String csvFile;
    private BufferedReader csvReader;

     public ColoringReader() throws FileNotFoundException {

        this.csvFile = "sentiments.csv";
        this.csvReader = new BufferedReader(new FileReader(csvFile));
    }
     
      public Map returnColoringHashMap() throws FileNotFoundException {

        Map<String, String> ht = new HashMap<String, String>();
        String line = "";
        
        Parser<String[]> parser = new ColoringParser();

        try {

            while ((line = csvReader.readLine()) != null) {
                ht.put(parser.parser(line)[0], parser.parser(line)[1]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (csvReader != null) {
                try {
                    csvReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return ht;
    }
}
