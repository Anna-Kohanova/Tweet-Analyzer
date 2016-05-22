package threads;

import java.util.Map;
import reports.ColoringReport;
import reports.ReportInfo;

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
