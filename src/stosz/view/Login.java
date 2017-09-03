package stosz.view;

import stosz.model.http.ImageListener;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by yu on 2017/8/18.
 */
public class Login implements ImageListener {
    private JTextField username;
    private JPasswordField password;
    private JTextField code;
    private JButton button;
    private JLabel image;
    private JPanel panel;

    public JPanel getPanel() {
        return panel;
    }

    public Login() {
        image.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }

    public ImageListener getImageListener() {
        return this;
    }

    @Override
    public void showImage(byte[] buf) {
        image.setIcon(new ImageIcon(buf));
        image.updateUI();
    }
}
