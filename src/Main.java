import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;
import java.io.IOException;

public class Main {
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame window = new Window();
                window.setVisible(true);

                ((Window) window).encButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Controller encryptController = new Controller(((Window) window).origImagePath.getText(),
                                ((Window) window).origTextPath.getText(),
                                ((Window) window).outputImagePath.getText());
                        try {
                            encryptController.manage();
                        } catch (IOException iE) {
                            System.out.println(iE);
                        }
                    }
                });

                ((Window) window).decButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Controller decryptController = new Controller(((Window) window).encryptedImagePath.getText(),
                                ((Window) window).decryptedTextPath.getText());
                        try {
                            decryptController.manage();
//                            JDialog text = ((Window) window).createDialog("Decrypted text",
//                                    false, decryptController.decryptedText.toString());
                        } catch (IOException oE) {
                            System.out.println(oE);
                        }
                    }
                });
            }
        });
    }
}
