import java.awt.*;

public class Decryptor {
    Decryptor() {}

    public static StringBuffer getBinText(int arr[][]) {
        StringBuffer text = new StringBuffer();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                Color pixel = new Color(arr[i][j]);

                String buff = getPixelBits(pixel);
                text.append(buff);
                if (buff.length() < 3) return text;
            }
        }
        return text;
    }

    public static String getPixelBits(Color pixel) {
        String result = "";
        int rgb[] = { pixel.getRed(), pixel.getGreen(), pixel.getBlue() };

        for (int k = 0; k < 3; k++) {
            if ((rgb[k] & 128) != 0) {
                return result;
            }
            result += (rgb[k] & 1) == 0 ? 0 : 1;
        }
        return result;
    }

    public static StringBuffer getText(StringBuffer binText) {
        StringBuffer text = new StringBuffer();

        for (int i = 0; i < binText.length() / 8; i++) {
            int letter = Integer.parseInt(binText.substring(i * 8, (i + 1) * 8), 2);
            text.append((char) letter);
        }
        return text;
    }
}