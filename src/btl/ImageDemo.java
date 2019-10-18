package btl;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class ImageDemo extends JFrame {
    public ImageDemo(){
        setSize(800,800);
        setVisible(true);
        setLocation(500,150);
        JLabel label = new JLabel();
        add(label);
        label.setSize(750,750  );
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("vrchinhphuc.JPG");
        label.setIcon(icon);
    }

    public static void main(String[] args){
        ImageDemo id = new ImageDemo();
    }
}
