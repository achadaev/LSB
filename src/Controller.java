import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.imageio.ImageIO;

public class Controller {
    String type, origImagePath, origTextPath, outputImagePath, encryptedImagePath, decryptedTextPath;
    StringBuffer decryptedText;

    Controller(String origImgPath, String origTextPath, String savedImgPath) {
        this.type = "encrypt";
        this.origImagePath = origImgPath;
        this.origTextPath = origTextPath;
        this.outputImagePath = savedImgPath;
    }

    Controller(String encryptedImgPath, String decryptedTextPath) {
        this.type = "decrypt";
        this.encryptedImagePath = encryptedImgPath;
        this.decryptedTextPath = decryptedTextPath;
    }

    public void manage() throws IOException {
        switch(type) {
            case "encrypt": {
                OrigImage origImage = new OrigImage(origImagePath);
                try {
                    byte[] origText = Files.readAllBytes(Paths.get(origTextPath));
                } catch (Exception e) {
                    System.out.println(e);
                    return;
                }
                byte[] origText = Files.readAllBytes(Paths.get(origTextPath));
                String binText = Encryptor.byteArrayToBinString(origText);
                File outputImg = new File(outputImagePath);

                BufferedImage resultImage = origImage.changePixels(origImage.getOriginalPixels(), binText);

                for (int i = 0; i < resultImage.getWidth(); i++) {
                    for (int j = 0; j < resultImage.getHeight(); j++) {
                        int rgb = resultImage.getRGB(i, j);
                    }
                }

                ImageIO.write(resultImage, "bmp", outputImg);
                System.out.println("Encrypted image saved");
                break;
            }
            case "decrypt": {
                EncryptedImage encImage = new EncryptedImage(encryptedImagePath);
                decryptedText = Decryptor.getText(Decryptor.getBinText(encImage.getOriginalPixels()));
                try {
                    FileWriter outputFile = new FileWriter(decryptedTextPath);
                    outputFile.write(decryptedText.toString());
                    outputFile.close();
                } catch (Exception e) {
                    System.out.println(e);
                }

                System.out.println("Decrypted text saved");

                // Opening decrypted text file
                try {
                    Process process = Runtime.getRuntime().exec("notepad.exe " + decryptedTextPath);
                    process.waitFor();
                } catch (Exception e) {
                    System.out.println(e);
                }

                break;
            }
        }
    }
}