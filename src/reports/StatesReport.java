package reports;

import java.awt.Polygon;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import polygons.Polygons;
import tweetsData.State;
import tweetsData.Tweet;

public class StatesReport implements Reportable<String> {

    @Override
    public String getReportResult(ReportInfo info) {

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String stateName = "";
        String currentMaxState = "";
        int maxAmount = 0;

        try {

            Date firstDate = format.parse(info.getFirstDate());
            Date secondDate = format.parse(info.getSecondDate());

            for (State state : info.getStates()) {
                int count = 0;
                stateName = state.getStateName();

                for (Tweet tweet : info.getTweets()) {
                    if (((Tweet) tweet).getDate().after(firstDate) && ((Tweet) tweet).getDate().before(secondDate)) {

                        if (Polygons.isInside(tweet, state)) {
                            count++;                            
                        }
                    }
                }

                if (maxAmount < count) {
                    maxAmount = count;
                    currentMaxState = stateName;
                }

            }
        } catch (ParseException ex) {
            Logger.getLogger(StatesReport.class.getName()).log(Level.SEVERE, null, ex);
        }

        return currentMaxState;
    }

}
