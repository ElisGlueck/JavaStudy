package JavaLessons.Lesson1;

import java.util.Random;
import java.util.Scanner;

public class Lesson4 {
    private static int fieldSizeX;
    private static int fieldSizeY;
    private static char[][] field;
    private static final char dotX = 'X';
    private static final char dot0 = '0';
    private static final char dotEmpty = '_';
    private static char humanDot;
    private static char computerDot;
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static int humanScore;
    private static int computerScore;
    private static int roundCounter;
    private static int winLength;


    public static void main(String[] args) {
        play();
    }

    public static void play() {
        while (true) {
            chooseTheDot();
            playRound();
            System.out.printf("Score Human: %d; Score Computer: %d", humanScore, computerScore);
            System.out.print("Do you want to play again? Y or N");
            if (!scanner.next().toLowerCase().equals("y")) {
                System.out.println("Good bye!");
                break;
            }
        }
    }

    private static void playRound() {
        System.out.printf("Round %d starts\n", ++roundCounter);
        chooseFieldSize();
        printField();
        if (humanDot == dotX) {
            humanFirstTurn();
            } else {
                computerFirstTurn();
            }
        }

    private static void humanFirstTurn() {
        while (true) {
            humanTurn();
            printField();
            if (checkGame(humanDot)) break;
            computerTurn();
            printField();
            if (checkGame(computerDot)) break;
        }
    }

    private static void computerFirstTurn() {
        while (true) {
            computerTurn();
            printField();
            if (checkGame(computerDot)) break;
            humanTurn();
            printField();
            if (checkGame(humanDot)) break;
        }
    }

    private static boolean checkGame(char dot) {
        if (checkWin(dot)) {
            if (dot == humanDot) {
                System.out.println("The Human win!");
                humanScore++;
            } else {
                System.out.println("The computer wins!");
                computerScore++;
            }
            return true;
        }
        if (checkDraw()) return true;
        return false;
    }

    private static void chooseTheDot() {
        System.out.println("Please choose the dot type by typing 'X' or anything else");
        if (Scanner.next().toLowerCase().equals("x")) {
            humanDot = dotX;
            computerDot = dot0;
        } else {
            humanDot = dot0;
            computerDot = dotX;
        }
    }

    private static void chooseFieldSize() {
        int fieldSizeX;
        int fieldSizeY;
        System.out.println("Please choose the field size by typing two numbers split by whitespace as X and Y sizes");
        fieldSizeX = scanner.nextInt();
        fieldSizeY = scanner.nextInt();
        field = new char[fieldSizeX][fieldSizeY];
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
             field[x][y] = dotEmpty;
            }

        }
    }

    private static void printField() {
        for (int x = 0; x <= fieldSizeX; x++) {
            System.out.print(x + " ");
        }
        System.out.println();
        for (int x = 0; x < fieldSizeX; x++) {
            System.out.print((x + 1) + " ");
            for (int y = 0; y < fieldSizeY; y++) {
                System.out.print(field[x][y] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }

    private static boolean isCellValid(int x, int y){
        return x >= 0 && y >= 0 && x < fieldSizeX && y < fieldSizeY;
    }

    private static boolean isCellEmpty(int x, int y) {
        return field[x][y] == dotEmpty;
    }

    private static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Please enter coordinates of your turn split by whitespace as X and Y");
        x = scanner.nextInt() - 1;
        y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = humanDot;
    }

    private static void computerTurn() {
        int x;
        int y;
        do {
            x = random.nextInt();
            y = random.nextInt();
        } while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = computerDot;
    }

    private static void checkDraw() {

    }

    private static void checkWin() {

    }

}
