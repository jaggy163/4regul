package Fifteen;

import java.util.ArrayList;

public class AISolution {
    private Game game;
    private Game archiveGame;

    public AISolution(Game game) {
        this.game = new Game(game);
    }

    public ArrayList<Integer> solve() {
        ArrayList<Integer> turns = new ArrayList<>();
        archiveGame = new Game(game);
        int index = 0;
        int aimNumber=-1;
        int tryNumber;
        int lastNumber=-1;
        int currentNumber=-1;
        //System.out.println("Начинаем:\n" + game);
        int[][] field = game.getField();
        for (int i=0; i<15; i++) {
            if (field[i/4][i%4] != (i+1)) {
                aimNumber = i+1;
                break;
            }
        }
        //System.out.println("начинаем поиск " + aimNumber);
        while (!allIsOK(aimNumber)) {
            do {
                if (aimNumber<=4) { tryNumber = (int) (Math.random()*15 + 1); }
                else if (aimNumber<=8) { tryNumber = (int) (Math.random()*11 + 5); }
                else { tryNumber = (int) (Math.random()*7 + 9); }

            } while(!game.turnIsCorrect(tryNumber));
            game.doTurn(tryNumber);
            turns.add(tryNumber);
            index++;
            if (index%80==0) {
                game = new Game(archiveGame);
                turns.clear();
            }
        }
        //System.out.println(game);
        //System.out.println(game.getTurnCounter());
        game = new Game(archiveGame);

        //System.out.println(turns);
        for (int j=0; j<5; j++) {
            currentNumber = -1;
            lastNumber = -1;
            for (int i = 0; i < turns.size(); i++) {
                lastNumber = currentNumber;
                currentNumber = turns.get(i);
                if (currentNumber == lastNumber) {
                    turns.remove(i - 1);
                    i--;
                    turns.remove(i);
                    i--;
                    lastNumber = -1;
                    currentNumber = -1;
                }
            }
        }

        return turns;
    }

    // Выставляем единицу в верхний левый угол
    private void step01() {
        int onePos=-1;
        int blankPos;
        blankPos = game.blankPos();
        for (int i=0; i<16; i++) {
            if (game.getField()[i/4][i%4] == 1) {
                onePos = i;
                break;
            }
        }

    }

    private boolean allIsOK(int aimNumber) {
        for (int i=0; i<aimNumber; i++) {
            if (game.getField()[i/4][i%4] == i+1) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
