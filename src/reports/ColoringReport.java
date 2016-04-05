package reports;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import tweetsData.Tweet;

public class ColoringReport implements Reportable<Map<String, Double>> {

    @Override
    public Map<String, Double> getReportResult(ReportInfo info) {
        
        Map<String, Double> tweetColoring = new HashMap<>();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            Date firstDate = format.parse(info.getFirstDate());
            Date secondDate = format.parse(info.getSecondDate());

            for (Tweet tw : info.getTweets()) {
                Double weight = 0.0;
                if (tw.getDate().before(secondDate) && tw.getDate().after(firstDate)) {

                    for (Map.Entry<String, Double> map : info.getColoring().entrySet()) {
                        if (tw.getTweet().toLowerCase().contains(map.getKey().toLowerCase())) {
                            Double d = Double.valueOf(String.valueOf(map.getValue()));
                            weight += d;
                        }
                    }
                    tweetColoring.put(tw.getTweet(), weight);
                }
            }            

        } catch (ParseException ex) {
            Logger.getLogger(ColoringReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tweetColoring;
        
    }

}
