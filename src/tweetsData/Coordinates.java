package tweetsData;

public final class Coordinates {
    
    private final double x;
    private final double y;
    
    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }
    
    public int getX(int mult){
        return (int)(this.x * mult);
    }

    public int getY(int mult){
        return (int)(this.y * mult);    }
    
    
    public Coordinates(String coordinates){
        this.x = Double.parseDouble (coordinates.substring (coordinates.indexOf('[') + 1, coordinates.indexOf(',') - 1));
        this.y = Double.parseDouble (coordinates.substring (coordinates.indexOf(',') + 1, coordinates.indexOf(']') - 1));
    }
    
}

