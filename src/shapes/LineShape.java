package shapes;
import java.awt.*;

public class LineShape extends Shape {

    public LineShape(int x1,int y1,int x2,int y2,Color color,boolean dotted){
        super(x1,y1,x2,y2,color,false,dotted);
    }

    // Draws a straight line
    @Override
    public void draw(Graphics2D g2){
        g2.setColor(color);
        applyStroke(g2);
        g2.drawLine(x1,y1,x2,y2);
    }

    // Checks if point is within 5 units from the line segment
    @Override
    public boolean contains(int x, int y) {
        double distance = java.awt.geom.Line2D.ptSegDist(x1, y1, x2, y2, x, y);
        return distance <= 5; // sensitivity
    }
}
