package shapes;
import java.awt.*;
import java.util.*;

public class FreeHandShape implements MyShape {

    private ArrayList<Point> points=new ArrayList<>();
    private Color color;

    public FreeHandShape(Color color){
        this.color=color;
    }

    // Adds new point while dragging
    public void addPoint(int x,int y){
        points.add(new Point(x,y));
    }

    // Draws free hand lines
    @Override
    public void draw(Graphics2D g2){
        g2.setColor(color);
        for(int i=1;i<points.size();i++){
            Point p1=points.get(i-1);
            Point p2=points.get(i);
            g2.drawLine(p1.x,p1.y,p2.x,p2.y);
        }
    }

    // Checks if the given (x, y) is close to any point in the list (within distance < 5)
    @Override
    public boolean contains(int x, int y) {
        for (Point p : points) {
            if (p.distance(x, y) < 5)
                return true;
        }
        return false;
    }

    // Not used
   public void setColor(Color color){

   }
}
