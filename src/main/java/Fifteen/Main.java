package Fifteen;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Game game = Game.createNewGame();
        ArrayList<Integer> turns = new ArrayList<>();
        System.out.println(game);
        while (!game.win()) {
            System.out.println("Делайте ход");
            Scanner scanner = new Scanner(System.in);
            int turn = scanner.nextInt();
            System.out.println("Вы ввели : " + turn);
            if (game.turnIsCorrect(turn) && turn>=1 && turn<=15) {
                System.out.println("Manual turn.");
                game.doTurn(turn);
                System.out.println(game);
            } else if (turn==1488) {
                game.cheat();
                System.out.println(game);
            } else if (turn==322) {
                while (!game.win()) {
                    System.out.println("AISolution started.");
                    long startTime = System.currentTimeMillis();
                    AISolution ai = new AISolution(game);
                    turns = ai.solve();

                    for (int i = 0; i < 49; i++) {
                        long endTime = System.currentTimeMillis();
                        ArrayList<Integer> turns_tmp = new ArrayList<>();
                        AISolution ai1 = new AISolution(game);
                        turns_tmp = ai1.solve();
                        if (turns.size() > turns_tmp.size()) {
                            turns = turns_tmp;
                        }
                        if (endTime - startTime >= 30_000) {
                            System.out.println("Сложный ход");
                            break;
                        }
                    }
                    System.out.println(turns);

                    for (int i = 0; i < turns.size(); i++) {
                        game.doTurn(turns.get(i));
                        System.out.println(game);
                        Thread.sleep(250);
                    }
                }
            } else
            {
                System.out.println("Некорректный ход");
            }
        }
        System.out.println("Вы сделали " + game.getTurnCounter() + " ход(а/ов).");
        System.out.println("Победа");
    }
}
