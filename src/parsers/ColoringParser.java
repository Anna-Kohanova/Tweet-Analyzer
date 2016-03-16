package parsers;

public class ColoringParser implements Parser <String[]>{

    @Override
    public String[] parser(String line) {
        
        String cvsSplitBy = ",";
        String[] words = line.split(cvsSplitBy);

        return words;
    }
}
