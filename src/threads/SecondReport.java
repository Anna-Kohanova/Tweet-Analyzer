package threads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import reader.StateReader;
import reports.HashtagReport;
import reports.ReportInfo;
import reports.StatesReport;
import tweetsData.Tweet;

public class SecondReport extends Thread {
    
    private String state;
    private ReportInfo info;
    
    public SecondReport(ReportInfo info) {
        this.info = info;
    }
        
    
    public void run(){
        StatesReport statesReport = new StatesReport();
        this.state = statesReport.getReportResult(info); 
    }
     
    public String getResultState() {
        return state;
    }
}
