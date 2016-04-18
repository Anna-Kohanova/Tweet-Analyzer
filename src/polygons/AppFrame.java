package polygons;

import javax.swing.*;
import java.awt.*;
import java.awt.Polygon;
import java.util.ArrayList;

public class AppFrame extends JFrame {
    
    static final String appTitle = "Frame-Application";
    static ArrayList<Polygon> polygons;
    
    public void draw(ArrayList<Polygon> polygons) {

        this.polygons = polygons;
        AppFrame frame = new AppFrame();
        
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setSize(new Dimension(1000, 700));
        frame.setTitle("Map");
        frame.setVisible(true);
        
        frame.repaint();
    }

    @Override
    public void paint(Graphics g) {
        
        int k = 1;
        
        for (Polygon p1 : this.polygons) {
            if (k % 6 == 0) {
                g.setColor(Color.red);
            } else if (k % 4 == 0) {
                g.setColor(Color.BLACK);
            } else if (k % 5 == 0) {
                g.setColor(Color.BLUE);
            } else if (k % 3 == 0) {
                g.setColor(Color.green);
            } else if (k % 2 == 0) {
                g.setColor(Color.CYAN);
            } else {
                g.setColor(Color.ORANGE);
            }
            g.fillPolygon(p1);
            
            k++;
        }
    }
}