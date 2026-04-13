package shapes;
import java.awt.*;

public class LineShape extends Shape {

    public LineShape(int x1,int y1,int x2,int y2,Color color,boolean dotted){
        super(x1,y1,x2,y2,color,false,dotted);
    }

    // Draws a straight line
    public void draw(Graphics2D g2){
        g2.setColor(color);
        applyStroke(g2);
        g2.drawLine(x1,y1,x2,y2);
    }

    // Checks if point lies in bounding box
    public boolean contains(int x,int y){
        return new Rectangle(Math.min(x1,x2),Math.min(y1,y2),
                Math.abs(x2-x1),Math.abs(y2-y1)).contains(x,y);
    }
}
