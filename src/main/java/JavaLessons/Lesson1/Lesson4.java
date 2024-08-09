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
            System.out.printf("Score Human: %d; Score Computer: %d\n", humanScore, computerScore);
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
        chooseWinLength();
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
        if (scanner.next().toLowerCase().equals("x")) {
            humanDot = dotX;
            computerDot = dot0;
        } else {
            humanDot = dot0;
            computerDot = dotX;
        }
    }

    private static void chooseFieldSize() {
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

    private static void chooseWinLength() {
        int winLengthInput;
        while (true) {
            System.out.println("Please choose the win length by typing a number (must be between 3 and " + Math.min(fieldSizeX, fieldSizeY) + ")");

            if (scanner.hasNextInt()) {
                winLengthInput = scanner.nextInt();

                if (winLengthInput >= 3 && winLengthInput <= fieldSizeX && winLengthInput <= fieldSizeY) {
                    winLength = winLengthInput;
                    break;
                } else {
                    System.out.println("Invalid win length. Please enter a number between 3 and " + Math.min(fieldSizeX, fieldSizeY) + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
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
        if (findAndPlaceDot(computerDot, winLength - 1)) return;

        if (findAndPlaceDot(humanDot, winLength - 1)) return;

        if (findAndPlaceDot(humanDot, winLength - 2)) return;

        makeRandomMove();
    }

    private static boolean findAndPlaceDot(char dot, int length) {
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if (isCellEmpty(x, y)) {
                    if (checkAndPlaceDot(dot, length, x, y, 1, 0) ||
                            checkAndPlaceDot(dot, length, x, y, 0, 1) ||
                            checkAndPlaceDot(dot, length, x, y, 1, 1) ||
                            checkAndPlaceDot(dot, length, x, y, 1, -1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean checkAndPlaceDot(char dot, int length, int startX, int startY, int dx, int dy) {
        int count = 0;
        for (int i = 1; i < winLength; i++) {
            int x = startX + i * dx;
            int y = startY + i * dy;
            if (isCellValid(x, y) && field[x][y] == dot) {
                count++;
            } else {
                break;
            }
        }
        if (count == length) {
            field[startX][startY] = computerDot;
            return true;
        }
        return false;
    }

    private static void makeRandomMove() {
        int x, y;
        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        } while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = computerDot;
    }

    private static boolean checkDraw() {
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if (isCellEmpty(x, y)) return false;
                
            }
            
        }
        System.out.println("It's a draw");
        return true;
    }

    private static boolean checkWin(char dot) {
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if (y + winLength <= fieldSizeY) {
                    boolean win = true;
                    for (int i = 0; i < winLength; i++) {
                        if (field[x][y + i] != dot) {
                            win = false;
                            break;
                        }
                    }
                    if (win) return true;
                }

                if (x + winLength <= fieldSizeX) {
                    boolean win = true;
                    for (int i = 0; i < winLength; i++) {
                        if (field[x + i][y] != dot) {
                            win = false;
                            break;
                        }
                    }
                    if (win) return true;
                }

                if (x + winLength <= fieldSizeX && y + winLength <= fieldSizeY) {
                    boolean win = true;
                    for (int i = 0; i < winLength; i++) {
                        if (field[x + i][y + i] != dot) {
                            win = false;
                            break;
                        }
                    }
                    if (win) return true;
                }

                if (x + winLength <= fieldSizeX && y - winLength >= -1) {
                    boolean win = true;
                    for (int i = 0; i < winLength; i++) {
                        if (field[x + i][y - i] != dot) {
                            win = false;
                            break;
                        }
                    }
                    if (win) return true;
                }
            }
        }
        return false;
    }

}
