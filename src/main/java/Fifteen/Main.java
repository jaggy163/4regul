package Fifteen;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = Game.createNewGame();
        System.out.println(game);
        while (!game.win()) {
            System.out.println("Делайте ход");
            Scanner scanner = new Scanner(System.in);
            int turn = scanner.nextInt();

            if (game.turnIsCorrect(turn)) {
                game.doTurn(turn);
                System.out.println(game);
            } else if (turn==1488) {
                game.cheat();
                System.out.println(game);
            } else if (turn==322) {
                AISolution.solve(game);
            } else
            {
                System.out.println("Некорректный ход");
            }
        }
        System.out.println("Вы сделали " + game.getTurnCounter() + " ход(а/ов).");
        System.out.println("Победа");
    }
}
