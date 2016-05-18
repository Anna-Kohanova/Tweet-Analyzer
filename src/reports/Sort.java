/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import tweetsData.Tweet;

/**
 *
 * @author Ania
 */
public class Sort {

    private ArrayList<Tweet> tweets;

    public Sort(ArrayList<Tweet> tweets) {
        this.tweets = tweets;
    }

    public ArrayList<Tweet> sorting() {
        Collections.sort(tweets, new Comparator<Tweet>() {

            @Override
            public int compare(Tweet t, Tweet t1) {
                 return t.getDate().compareTo(t1.getDate());                    
            }
        });
        return tweets;
    }
}
