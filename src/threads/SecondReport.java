package threads;

import reports.ReportInfo;
import reports.StatesReport;

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
