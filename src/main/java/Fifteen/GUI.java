package Fifteen;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    JPanel panel = new JPanel();
    public int turnOut;


    GUI() {
        super("Victory");
        JPanel panel = new JPanel();
        int width = 150;
        int height = 120;
        int locationX = (screenSize.width-width)/2;
        int locationY = (screenSize.height-height)/2;

        setSize(width,height);
        setLocation(locationX, locationY);

        JButton exitButton = new JButton("Выход");
        exitButton.addActionListener(e -> System.exit(0));
        JLabel label = new JLabel("Победа!");
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);

        panel.setLayout(new GridLayout(2,0));
        panel.add(label);
        panel.add(exitButton);
        add(panel);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    GUI(int[][] numbers) {
        super("Fifteen");
        JPanel secondPanel = new JPanel();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        int width = 400;
        int height = 530;
        int locationX = (screenSize.width-width)/2;
        int locationY = (screenSize.height-height)/2;

        setSize(width,height);
        setLocation(locationX, locationY);

        panel.setPreferredSize(new Dimension(400,400));
        secondPanel.setPreferredSize(new Dimension(400,100));
        secondPanel.setLayout(new GridLayout(3,3));

        GridLayout layout = new GridLayout(4,4);

        int text;
        JTextField textField = new JTextField();
        try {
            textField.addActionListener(e -> doTurn(Integer.valueOf(textField.getText())));
        } catch (Exception e) {
            textField.setText("");
            e.printStackTrace();
        }

        JButton buttonDoTurn = new JButton("Принять");
        try {
            buttonDoTurn.addActionListener(e -> doTurn(Integer.valueOf(textField.getText())));
        } catch (Exception e) {
            textField.setText("");
            e.printStackTrace();
        }
        JLabel label = new JLabel("Ваш ход:");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);

        secondPanel.add(new JLabel(" "));
        secondPanel.add(label);
        secondPanel.add(new JLabel(" "));
        secondPanel.add(new JLabel(" "));
        secondPanel.add(textField);
        secondPanel.add(new JLabel(" "));
        secondPanel.add(new JLabel(" "));
        secondPanel.add(buttonDoTurn);
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
