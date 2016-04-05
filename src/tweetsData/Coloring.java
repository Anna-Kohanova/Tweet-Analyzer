package tweetsData;

import java.util.HashMap;
import java.util.Map;

public final class Coloring {
    
    private static Map<String, Double> coloring;

    public static Map<String, Double> getColoring() {
        return coloring;
    }

    public static void setColoring(Map<String, Double> coloring) {
        Coloring.coloring = coloring;
    }
    
}
