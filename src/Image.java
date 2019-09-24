import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Image {
    protected BufferedImage image;

    Image(String path) {
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            System.out.println("Image loading error");
            System.exit(0);
        }
    }

    public int[][] getOriginalPixels() {
        int width = image.getWidth();
        int height = image.getHeight();
        int arr[][] = new int[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                arr[i][j] = image.getRGB(i, j);
//                Color origColor = new Color(arr[i][j]);
//                String r = Integer.toBinaryString(origColor.getRed());
//                String g = Integer.toBinaryString(origColor.getGreen());
//                String b = Integer.toBinaryString(origColor.getBlue());
//                System.out.println(r.charAt(b.length() - 1) + "\t" +
//                        g.charAt(b.length() - 1) + "\t" +
//                        b.charAt(b.length() - 1));
            }
        }
        return arr;
    }
}
