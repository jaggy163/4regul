package lostfilm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Scanner;

public class Report extends JFrame {
    private String report;

    public Report(String report) {
        this.report = report;
    }

    private void doReport(String report) {
        JLabel reportLable;
        // Создание окна
        JPanel grid = new JPanel();
        GridLayout layout = new GridLayout(2, 0, 5, 12);
        grid.setLayout(layout);
        // Закрытие программы при закрытие фрейма
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Пишем отчет
        Scanner scanner = new Scanner(report);
        scanner.useDelimiter("\n");
        grid.add(new JLabel(scanner.next()));

        //TODO добавим ссылку на сайт.
        JButton buttonExit = new JButton("Exit");
        buttonExit.addActionListener(e -> dispose());
        grid.add(buttonExit);

        setBounds(680, 240, 200, 150);
        getContentPane().add(grid);
        setVisible(true);
    }

    public void run() {
        doReport(report);
    }

}