package tweetsData;

public final class Coordinates {
    
    private int x = 0;
    private int y = 0;
    
    public int getX() {
        return this.y;
    }
    
    public int getY() {
        return this.x;
    }
    
    public Coordinates(String coordinates){
        this.x = (int)(Double.parseDouble (coordinates.substring (coordinates.indexOf('[') + 1, coordinates.indexOf(',') - 1))*1000000);
        this.y = (int)(Double.parseDouble (coordinates.substring (coordinates.indexOf(',') + 1, coordinates.indexOf(']') - 1))*1000000);
    }
    
}

