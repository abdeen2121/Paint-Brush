package shapes;
import java.awt.*;

public abstract class Shape implements MyShape  {

    protected int x1, y1, x2, y2;
    protected Color color;
    protected boolean filled;
    protected boolean dotted;

    public Shape(int x1,int y1,int x2,int y2,
                         Color color,boolean filled,boolean dotted){
        this.x1=x1; this.y1=y1;
        this.x2=x2; this.y2=y2;
        this.color=color;
        this.filled=filled;
        this.dotted=dotted;
    }

    // Each shape must implement its own drawing logic
    public abstract void draw(Graphics2D g2);

    // Each shape must define how to detect containment
    public abstract boolean contains(int x,int y);

    // Applies stroke style (solid or dotted)
    protected void applyStroke(Graphics2D g2){
        if(dotted){
            float[] dash={10};
            g2.setStroke(new BasicStroke(2,
                    BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_BEVEL,0,dash,0));
        }else{
            g2.setStroke(new BasicStroke(2));
        }
    }

    // Sets color of shape
    public void setColor(Color color){
        this.color=color;
    }
}
