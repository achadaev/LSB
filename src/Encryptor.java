import java.awt.*;

public class Encryptor {

    Encryptor() {}

    public static String byteArrayToBinString(byte[] byteArray) {
        String result = "";

        for (byte i : byteArray) {
            int bit = i;
            for (int j = 0; j < 8; j++) {
                result += (bit & 128) == 0 ? 0 : 1;
                bit <<= 1;
            }
        }
        return result;
    }

    public static int encryptPixel(Color origPixel, String binText, int flag) {
        int rInt = origPixel.getRed(), gInt = origPixel.getGreen(), bInt = origPixel.getBlue();

        for (int k = 0; k < 3; k++) {
            if (flag < binText.length()) {
                switch(k) {
                    case 0: rInt = setBit(rInt, Character.getNumericValue(binText.charAt(flag)));
                        break;

                    case 1: gInt = setBit(gInt, Character.getNumericValue(binText.charAt(flag)));
                        break;

                    case 2: bInt = setBit(bInt, Character.getNumericValue(binText.charAt(flag)));
                        break;
                }
                flag++;
            }
            else if (flag == binText.length()) {
                switch(k) {
                    case 0: rInt |= 1 << 7;
                        break;

                    case 1: gInt |= 1 << 7;
                        break;

                    case 2: bInt |= 1 << 7;
                        break;
                }
                flag++;
            }
        }

        Color newPixel = new Color(rInt, gInt, bInt);
        return newPixel.getRGB();
    }

    private static int setBit(int value, int bit) {
        switch(bit) {
            case 0: return value &= ~ 1;
            case 1: return value |= 1;
        }
        return 0;
    }
}
