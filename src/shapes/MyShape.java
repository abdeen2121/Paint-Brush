package shapes;
import java.awt.*;

public interface MyShape {

    // Draws the shape using Graphics2D
    void draw(Graphics2D g2);

    // Checks if a point is inside the shape (used for eraser/selection)
    boolean contains(int x, int y);

    // Sets the color of the shape
    void setColor(Color color);
}
