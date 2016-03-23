package reports;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import tweetsData.Tweet;

public class ColoringReport implements Reportable<Map<String, Double>> {

    private Map<String, Double> coloring;
    private ArrayList<Tweet> tweets;
    private Double weight;
    private Date firstDate;
    private Date secondDate;

    public ColoringReport(Map<String, Double> coloring, ArrayList<Tweet> tweets, String firstDate, String secondDate) throws ParseException {
        this.coloring = coloring;
        this.tweets = tweets;
        this.weight = 0.0;
        
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.firstDate = format.parse(firstDate);
        this.secondDate = format.parse(secondDate);
    }

    @Override
    public Map<String, Double> getReportResult() {
        Map<String, Double> tweetColoring = new HashMap<>();

            for (Tweet tw : tweets) {
                this.weight = 0.0;
                if (tw.getDate().before(secondDate) && tw.getDate().after(firstDate)) {

                    for (Map.Entry<String, Double> map : coloring.entrySet()) {
                        if (tw.getTweet().toLowerCase().contains(map.getKey().toLowerCase())) {
                            Double d = Double.valueOf(String.valueOf(map.getValue()));
                            weight += d;
                        }
                    }
                    tweetColoring.put(tw.getTweet(), weight);
                }
            }

        return tweetColoring;
    }

}
