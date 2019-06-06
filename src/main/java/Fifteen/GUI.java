package Fifteen;


import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    GUI(int[][] numbers) {
        super("test");
        JPanel panel = new JPanel();
        JPanel secondPanel = new JPanel();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,530);
        panel.setPreferredSize(new Dimension(400,400));
        secondPanel.setPreferredSize(new Dimension(400,100));
        secondPanel.setLayout(new GridLayout(3,3));

        GridLayout layout = new GridLayout(4,4);
        secondPanel.add(new JLabel(" "));
        secondPanel.add(new JLabel("Ваш ход:"), BorderLayout.CENTER);
        secondPanel.add(new JLabel(" "));
        secondPanel.add(new JLabel(" "));
        secondPanel.add(new JTextField());
        secondPanel.add(new JLabel(" "));
        secondPanel.add(new JLabel(" "));
        secondPanel.add(new JLabel(" "));
        secondPanel.add(new JLabel(" "));
        panel.setLayout(layout);
        for (int i=0; i<16; i++) {
            panel.add(new JButton("" + numbers[i/4][i%4]));
        }
        add(panel, BorderLayout.NORTH);
        add(secondPanel, BorderLayout.SOUTH);
        setVisible(true);
    }
}
