package threads;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import reader.ColoringReader;

public class ClReader extends Thread {
    
    private Map<String, Double> ht;
    
    public ClReader() {
        
    }
    
     public void run(){
         try {
             ColoringReader coloringReader = new ColoringReader();
             try {
                 this.ht = coloringReader.returnColoringHashMap();
             } catch (IOException ex) {
                 Logger.getLogger(StReader.class.getName()).log(Level.SEVERE, null, ex);
             }
         } catch (FileNotFoundException ex) {
             Logger.getLogger(ClReader.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    /**
     * @return the states
     */
    public Map<String, Double> getHt() {
        return ht;
    }
}
