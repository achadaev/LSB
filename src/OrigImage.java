import java.awt.*;
import java.awt.image.BufferedImage;

public class OrigImage extends Image {
    OrigImage(String path) {
        super(path);
    }

    public BufferedImage changePixels(int[][] arr, String binText) {
        int flag = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                Color origPixel = new Color(arr[i][j]);
                int encryptedRGB = Encryptor.encryptPixel(origPixel, binText, flag);
                image.setRGB(i, j, encryptedRGB);
                flag += 3;
                if (flag >= binText.length()) return image;
            }
        }
        return image;
    }
}