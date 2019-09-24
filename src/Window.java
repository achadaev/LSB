import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    JButton encButton, decButton;
    JTextField origImagePath, origTextPath, outputImagePath, encryptedImagePath, decryptedTextPath;

    Window() {
        super("LSB");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Box panel = Box.createVerticalBox();

        encButton = new JButton("Encrypt");
        encButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        decButton = new JButton("Decrypt");
        decButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        origImagePath = new JTextField(25);
        origTextPath = new JTextField(25);
        outputImagePath = new JTextField(25);
        encryptedImagePath = new JTextField(25);
        decryptedTextPath = new JTextField(25);

        panel.add(Box.createVerticalStrut(10));
        panel.add(new JLabel("Original image path"));
        panel.add(Box.createVerticalStrut(10));
        panel.add(origImagePath);
        panel.add(Box.createVerticalStrut(10));
        panel.add(new JLabel("Original text path"));
        panel.add(Box.createVerticalStrut(10));
        panel.add(origTextPath);
        panel.add(Box.createVerticalStrut(10));
        panel.add(new JLabel("Output image path"));
        panel.add(Box.createVerticalStrut(10));
        panel.add(outputImagePath);
        panel.add(Box.createVerticalStrut(10));
        panel.add(encButton);

        Box.createVerticalGlue();

        panel.add(Box.createVerticalStrut(10));
        panel.add(new JLabel("Encrypted image path"));
        panel.add(Box.createVerticalStrut(10));
        panel.add(encryptedImagePath);
        panel.add(Box.createVerticalStrut(10));
        panel.add(new JLabel("Decrypted text path"));
        panel.add(Box.createVerticalStrut(10));
        panel.add(decryptedTextPath);
        panel.add(Box.createVerticalStrut(10));
        panel.add(decButton);
        panel.add(Box.createVerticalStrut(10));

        setContentPane(panel);

        this.pack();
        this.setLocationRelativeTo(null);
    }

    public JDialog createDialog(String title, boolean modal, String mes) {
        JDialog message = new JDialog(this, title, modal);
        message.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        message.setLocationRelativeTo(null);
        JLabel text = new JLabel(mes);
        add(text);
        return message;
    }
}