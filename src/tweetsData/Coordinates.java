package tweetsData;

public final class Coordinates {
    
    private static double x;
    private static double y;
    
    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }
    
    public Coordinates(String coordinates){
        this.x = Double.parseDouble (coordinates.substring (coordinates.indexOf('[') + 1, coordinates.indexOf(',') - 1));
        this.y = Double.parseDouble (coordinates.substring (coordinates.indexOf(',') + 1, coordinates.indexOf(']') - 1));
    }
    
}

