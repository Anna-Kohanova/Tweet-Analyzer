package reports;

/**
 * Generic interface for making task reports with the method getReportResult
 * @author Ania
 * @param <T> 
 */

public interface Reportable <T> {
    public T getReportResult(ReportInfo info);
    
}
