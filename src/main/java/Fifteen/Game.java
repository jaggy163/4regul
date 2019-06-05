package Fifteen;

public class Game {
    private int[][] field;
    private int[] numbers = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,0};
    private int turnCounter=0;

    Game() {
        field = new int[4][4];
        for (int i=0; i<4; i++) {
            for (int j=0; j<4; j++) {
                field[i][j] = numbers[i*4 + j];
            }
        }
        for (int i=0; i<1000; i++) {
            int tmp;
            int swap1, swap2;
            swap1 = (int) (Math.random()*15);
            swap2 = (int) (Math.random()*15);
            tmp = field[swap1/4][swap1%4];
            field[swap1/4][swap1%4] = field[swap2/4][swap2%4];
            field[swap2/4][swap2%4] = tmp;
        }
    }

    Game(Game game) {
        this.field = new int[4][4];
        for (int i=0; i<16; i++) {
            this.field[i/4][i%4] = game.getField()[i/4][i%4];
        }
        this.turnCounter = game.getTurnCounter();
    }

    public int[][] getField() {
        return field;
    }

    public static Game createNewGame() {
        Game game;
        do {
            game = new Game();
        } while (!game.gameIsCorrect());
        return game;
    }

    public int getTurnCounter() {
        return turnCounter;
    }

    public boolean win() {
        boolean isWin = true;
        for (int i=0; i<numbers.length; i++) {
            if (field[i/4][i%4] != numbers[i]) {
                isWin = false;
            }
        }
        return isWin;
    }

    public void doTurn(int turn) {
        int row = 0, column = 0, rowEmpty = 0, columnEmpty = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (field[i / 4][i % 4] == turn) {
                row = i / 4;
                column = i % 4;
            }
            if (field[i / 4][i % 4] == 0) {
                rowEmpty = i / 4;
                columnEmpty = i % 4;
            }
        }
        if (turnIsCorrect(row, column, rowEmpty, columnEmpty)) {
            field[rowEmpty][columnEmpty] = field[row][column];
            field[row][column] = 0;
        }
        turnCounter++;
    }

    public boolean turnIsCorrect(int turn) {
        boolean result=false;
        int row=0, column=0, rowEmpty=0, columnEmpty=0;
        for (int i = 0; i < numbers.length; i++) {
            if (field[i / 4][i % 4] == turn) {
                row = i / 4;
                column = i % 4;
            }
            if (field[i / 4][i % 4] == 0) {
                rowEmpty = i / 4;
                columnEmpty = i % 4;
            }
        }
        if ( (row==rowEmpty || column==columnEmpty) && (Math.abs(row-rowEmpty)==1 || Math.abs(column-columnEmpty)==1) ) {
            result = true;
        }
        return result;
    }

    private boolean turnIsCorrect(int row, int column, int rowEmpty, int columnEmpty) {
        boolean result=false;
        if ( (row==rowEmpty || column==columnEmpty) && (Math.abs(row-rowEmpty)==1 || Math.abs(column-columnEmpty)==1) ) {
            result = true;
        }
        return result;
    }

    public boolean gameIsCorrect() {
        int evenness = 0;
        for (int i=0; i<15; i++) {
            for (int j=i+1; j<15; j++) {
                if (field[i/4][i%4] > field[j/4][j%4]) {
                    evenness++;
                }
            }
        }
        return evenness%2==0;
    }


    @Override
    public String toString() {
        String result = "";
        result += (field[0][0]!=0 ? field[0][0] : " ") + "\t" + (field[0][1]!=0 ? field[0][1] : " ") + "\t" + (field[0][2]!=0 ? field[0][2] : " ") + "\t" + (field[0][3]!=0 ? field[0][3] : " ") + "\n";
        result += (field[1][0]!=0 ? field[1][0] : " ") + "\t" + (field[1][1]!=0 ? field[1][1] : " ") + "\t" + (field[1][2]!=0 ? field[1][2] : " ") + "\t" + (field[1][3]!=0 ? field[1][3] : " ") + "\n";
        result += (field[2][0]!=0 ? field[2][0] : " ") + "\t" + (field[2][1]!=0 ? field[2][1] : " ") + "\t" + (field[2][2]!=0 ? field[2][2] : " ") + "\t" + (field[2][3]!=0 ? field[2][3] : " ") + "\n";
        result += (field[3][0]!=0 ? field[3][0] : " ") + "\t" + (field[3][1]!=0 ? field[3][1] : " ") + "\t" + (field[3][2]!=0 ? field[3][2] : " ") + "\t" + (field[3][3]!=0 ? field[3][3] : " ") + "\n";

        return result;
    }

    public void cheat() {
        for (int i=0; i<4; i++) {
            for (int j=0; j<4; j++) {
                field[i][j] = numbers[i*4 + j];
            }
        }
        field[3][2] = 0;
        field[3][3] = 15;
    }

    public int blankPos() {
        for (int i = 0; i < numbers.length; i++) {
            if (field[i/4][i%4] == 0) {
                return i;
            }
        }
        return -1;
    }
}
