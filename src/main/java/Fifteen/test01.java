package Fifteen;

import javax.swing.*;
import java.util.ArrayList;

public class test01 {
    public static void main(String[] args) throws InterruptedException {
        int[][] numbers = new int[4][4];
        for (int i=0; i<16; i++) {
            numbers[i/4][i%4] = i;
        }
        GUI jFrame = new GUI(numbers);

        int index = 0;
        while (true) {
            Thread.sleep(500);
            if (index%2==0) {
                numbers[0][2] = 15;
                numbers[3][3] = 2;
            } else {
                numbers[0][2] = 2;
                numbers[3][3] = 15;
            }
            index++;
            System.out.println("1");
            jFrame.refresh(numbers);
        }
    }
}
