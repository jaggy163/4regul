package Fifteen;

import java.util.ArrayList;

public class test01 {
    public static void main(String[] args) {
        int tmp;
        ArrayList<Integer> turns = new ArrayList<>();
        for (int i=0; i<50; i++) {
            tmp = (int) (Math.random()*15 + 1);
            System.out.println(tmp);
            turns.add(tmp);
            if (i%10 == 0) turns.clear();
        }
        System.out.println(turns);
    }
}
