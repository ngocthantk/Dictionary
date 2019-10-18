package btl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JLabelTest extends JFrame implements ActionListener{
    private JLabel label;
    private JButton button;
    public JLabelTest(){
        setSize(800,800);
        setVisible(true); // hien khung
        setLocation(500,150);
        setResizable(false); // khong thay doi duoc kich thuoc khi bat len
        label = new JLabel("Tu Dien"); // hien chu
        add(label);
        label.setText("Viet Nam");
        label.setToolTipText("cjdshdf"); // chu thich cho label
        label.setForeground(java.awt.Color.GREEN); // set mau chu cho label
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JButton button  = new JButton("Tra Cuu");
        add(button, "North", 1);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    changeText();
                }
        });
    }

    public void changeText(){
        label.setText("tutorial");
    }
    public static void main(String[] args){
        JLabelTest da = new JLabelTest();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        if (b == button){
            label.setText("hahaha");
        }
    }
}
