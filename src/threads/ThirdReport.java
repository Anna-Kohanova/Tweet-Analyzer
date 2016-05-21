package threads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import reader.StateReader;
import reports.ColoringReport;
import reports.HashtagReport;
import reports.ReportInfo;
import reports.StatesReport;
import tweetsData.Tweet;

public class ThirdReport extends Thread {
    
    private Map<String, Double> tweetColoring;
    private ReportInfo info;
    
    public ThirdReport(ReportInfo info) {
        this.info = info;
    }
        
    
    public void run(){
        ColoringReport coloringReport = new ColoringReport();
        this.tweetColoring = coloringReport.getReportResult(info);
    }
     
    public Map<String, Double> getTweetColoring() {
        return tweetColoring;
    }
}
