package JavaLessons.Lesson1.Lesson8;

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class GameMap extends JPanel {
        public static final int MODE_VS_COMPUTER = 0;
        public static final int MODE_VS_HUMAN = 1;
        public static final Random random = new Random();
        private static final int dotEmpty = 0;
        private static final int dotHuman = 1;
        private static final int dotComputer = 2;
        private static final int dotPadding = 7;
        private static final int StateDraw = 0;
        private static final int StateWinHuman = 1;
        private static final int StateWinComputer = 2;

        private int stateGameOver;
        private int fieldSizeX;
        private int fieldSizeY;
        private int[][] field;
        private int winLength;
        private int cellWidth;
        private int cellHeight;
        private int gameMode;
        private int playerNumTurn;
        private boolean isGameOver;
        private boolean isInitialized;

        private static final int dotX = 'X'; //Cut?
        private static final int dot0 = '0'; //Cut?
        private static final Scanner scanner = new Scanner(System.in);
        private static int humanScore;
        private static int computerScore;
        private static int roundCounter;

        public GameMap() {}


        public void main(String[] args) {
            play();
        }

        public void play() {
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

        private void playRound() {
            System.out.printf("Round %d starts\n", ++roundCounter);
            chooseFieldSize();
            chooseWinLength();
            printField();
            if (dotHuman == dotX) {
                humanFirstTurn();
            } else {
                computerFirstTurn();
            }
        }

        private void humanFirstTurn() {
            while (true) {
                humanTurn();
                printField();
                if (checkGame(dotHuman)) break;
                computerTurn();
                printField();
                if (checkGame(dotComputer)) break;
            }
        }

        private void computerFirstTurn() {
            while (true) {
                computerTurn();
                printField();
                if (checkGame(dotComputer)) break;
                humanTurn();
                printField();
                if (checkGame(dotHuman)) break;
            }
        }

        private boolean checkGame(int dot, int stateGameOver) {
            if (checkWin(dot, winLength)) {
                if (dot == dotHuman) {
                    System.out.println("The Human win!");
                    humanScore++;
                } else {
                    System.out.println("The computer wins!");
                    computerScore++;
                }
                this.stateGameOver = stateGameOver;
                isGameOver = true;
                repaint();
                return true;
            }
            if (checkDraw()) {
                this.stateGameOver = StateDraw;
                isGameOver = true;
                repaint();
                return true;
            }
            return false;
        }

        private void chooseTheDot() {
            System.out.println("Please choose the dot type by typing 'X' or anything else");
            if (scanner.next().toLowerCase().equals("x")) {
                dotHuman = dotX;
                dotComputer = dot0;
            } else {
                dotHuman = dot0;
                dotComputer = dotX;
            }
        }

        private void chooseFieldSize() {
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

        private void chooseWinLength() {
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

        private void printField() {
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

        private boolean isCellValid(int x, int y){
            return x >= 0 && y >= 0 && x < fieldSizeX && y < fieldSizeY;
        }

        private boolean isCellEmpty(int x, int y) {
            return field[x][y] == dotEmpty;
        }

        private void humanTurn() {
            int x;
            int y;
            do {
                System.out.println("Please enter coordinates of your turn split by whitespace as X and Y");
                x = scanner.nextInt() - 1;
                y = scanner.nextInt() - 1;
            } while (!isCellValid(x, y) || !isCellEmpty(x, y));
            field[x][y] = dotHuman;
        }

        private void computerTurn() {
            if (findAndPlaceDot(dotComputer, winLength - 1)) return;

            if (findAndPlaceDot(dotHuman, winLength - 1)) return;

            if (findAndPlaceDot(dotHuman, winLength - 2)) return;

            makeRandomMove();
        }

        private boolean findAndPlaceDot(char dot, int length) {
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

        private boolean checkAndPlaceDot(char dot, int length, int startX, int startY, int dx, int dy) {
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
                field[startX][startY] = dotComputer;
                return true;
            }
            return false;
        }

        private void makeRandomMove() {
            int x, y;
            do {
                x = random.nextInt(fieldSizeX);
                y = random.nextInt(fieldSizeY);
            } while (!isCellValid(x, y) || !isCellEmpty(x, y));
            field[x][y] = dotComputer;
        }

        private boolean checkDraw() {
            for (int x = 0; x < fieldSizeX; x++) {
                for (int y = 0; y < fieldSizeY; y++) {
                    if (isCellEmpty(x, y)) return false;

                }

            }
            System.out.println("It's a draw");
            return true;
        }

        private boolean checkWin(char dot) {
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
