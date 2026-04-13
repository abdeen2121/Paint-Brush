package shapes;
import java.awt.*;

public class EraserShape extends Shape {

    public EraserShape(int x1,int y1,int x2,int y2){
        super(x1,y1,x2,y2,Color.WHITE,true,false);
    }

    // Draws white rectangle to simulate erasing
    public void draw(Graphics2D g2){
        g2.setColor(Color.WHITE);
        g2.fillRect(Math.min(x1,x2),Math.min(y1,y2),
                Math.abs(x2-x1),Math.abs(y2-y1));
    }

    public boolean contains(int x,int y){
        return false;
    }
}
