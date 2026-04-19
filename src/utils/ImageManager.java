package utils;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageManager {

    // Saves image to file
    public static void saveImage(BufferedImage img, File file) throws Exception {
        ImageIO.write(img,"png",file);
    }

    // Loads image from file
    public static BufferedImage loadImage(File file) throws Exception {
        return ImageIO.read(file);
    }
}
