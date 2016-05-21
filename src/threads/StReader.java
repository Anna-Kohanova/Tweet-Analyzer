package threads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import reader.StateReader;

public class StReader extends Thread {
    
    private ArrayList<tweetsData.State> states;
    
    public StReader() {
        
    }
    
     public void run(){
        StateReader stateReader = new StateReader();
         try {
             this.states = stateReader.reader();
         } catch (IOException ex) {
             Logger.getLogger(StReader.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    /**
     * @return the states
     */
    public ArrayList<tweetsData.State> getStates() {
        return states;
    }

    /**
     * @param states the states to set
     */
    public void setStates(ArrayList<tweetsData.State> states) {
        this.states = states;
    }
}
