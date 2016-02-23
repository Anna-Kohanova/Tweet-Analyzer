/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tweetsData;

public class Coordinates {
    
    private double X;
    private double Y;
    
    public double getX() {
        return this.X;
    }
    
    public double getY() {
        return this.Y;
    }
    
    public Coordinates(String coordinates){
        this.X = Double.parseDouble (coordinates.substring (coordinates.indexOf('[') + 1, coordinates.indexOf(',') - 1));
        this.Y = Double.parseDouble (coordinates.substring (coordinates.indexOf(',') + 1, coordinates.indexOf(']') - 1));
    }
    
}

