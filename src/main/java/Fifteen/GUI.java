package Fifteen;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    JPanel panel = new JPanel();
    public int turnOut;

    GUI() {
        super("Victory");
        JPanel panel = new JPanel();
        setSize(400,530);
        panel.add(new JLabel("Победа!"));
        add(panel);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    GUI(int[][] numbers) {
        super("Fifteen");
        JPanel secondPanel = new JPanel();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,530);
        panel.setPreferredSize(new Dimension(400,400));
        secondPanel.setPreferredSize(new Dimension(400,100));
        secondPanel.setLayout(new GridLayout(3,3));

        GridLayout layout = new GridLayout(4,4);

        int text;
        JTextField textField = new JTextField();
        try {
            textField.addActionListener(e -> doTurn(Integer.valueOf(textField.getText())));
        } catch (Exception e) {
            textField.removeAll();
            e.printStackTrace();
        }

        JButton buttonDoTurn = new JButton("Принять");
        try {
            buttonDoTurn.addActionListener(e -> doTurn(Integer.valueOf(textField.getText())));
        } catch (Exception e) {
            textField.removeAll();
            e.printStackTrace();
        }

        secondPanel.add(new JLabel(" "));
        secondPanel.add(new JLabel("Ваш ход:"), BorderLayout.CENTER);
        secondPanel.add(new JLabel(" "));
        secondPanel.add(new JLabel(" "));
        secondPanel.add(textField);
        secondPanel.add(new JLabel(" "));
        secondPanel.add(new JLabel(" "));
        secondPanel.add(buttonDoTurn, BorderLayout.CENTER);
        secondPanel.add(new JLabel(" "));

        panel.setLayout(layout);

        refresh(numbers);

        add(panel, BorderLayout.NORTH);
        add(secondPanel, BorderLayout.SOUTH);
        setVisible(true);
    }


    public void refresh(int[][] numbers) {
        panel.removeAll();
        for (int i=0; i<16; i++) {
            if (numbers[i/4][i%4]==0) {
                panel.add(new JLabel(" "));
                continue;
            }
            JButton button = new JButton("" + numbers[i/4][i%4]);
            int iFinal = i;
            button.addActionListener(e -> doTurn(numbers[iFinal/4][iFinal%4]));
            panel.add(button);
        }

        setVisible(true);
    }

    public void doTurn(int turn) {
        Main.turnFromGUI = turn;
    }
}
