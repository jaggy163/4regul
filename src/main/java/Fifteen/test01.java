package Fifteen;

import javax.swing.*;
import java.util.ArrayList;

public class test01 {
    public static void main(String[] args) {
        int[][] numbers = new int[4][4];
        for (int i=0; i<16; i++) {
            numbers[i/4][i%4] = i;
        }
        GUI jFrame = new GUI(numbers);
    }
}
