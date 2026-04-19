package shapes;
import java.awt.*;

public class RectShape extends Shape {

    public RectShape(int x1,int y1,int x2,int y2,
                     Color color,boolean filled,boolean dotted){
        super(x1,y1,x2,y2,color,filled,dotted);
    }

    // Draws rectangle (filled or outline)
    @Override
    public void draw(Graphics2D g2){
        g2.setColor(color);
        applyStroke(g2);

        int x=Math.min(x1,x2);
        int y=Math.min(y1,y2);
        int w=Math.abs(x2-x1);
        int h=Math.abs(y2-y1);

        if(filled) g2.fillRect(x,y,w,h);
        else g2.drawRect(x,y,w,h);
    }

    // Checks if point inside rectangle
    @Override
    public boolean contains(int x,int y){
        return new Rectangle(Math.min(x1,x2),Math.min(y1,y2),
                Math.abs(x2-x1),Math.abs(y2-y1)).contains(x,y);
    }
}
