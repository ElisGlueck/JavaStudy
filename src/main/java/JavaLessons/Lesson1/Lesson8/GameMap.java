package JavaLessons.Lesson1.Lesson8;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;


public class GameMap extends JPanel {
    public static final int MODE_VS_COMPUTER = 0;
    public static final int MODE_VS_HUMAN = 1;
    public static final Random random = new Random();

    private static final int DOT_EMPTY = 0;
    private static final int DOT_HUMAN = 1;
    private static final int DOT_COMPUTER = 2;
    private static final int DOT_PADDING = 7;
    private static final int STATE_DRAW = 0;
    private static final int STATE_WIN_HUMAN = 1;
    private static final int STATE_WIN_COMPUTER = 2;

    private int stateGameOver;
    private int fieldSizeX;
    private int fieldSizeY;
    private int[][] field;
    private int winLength;
    private int cellWidth;
    private int cellHeight;
    private int gameMode;
    private boolean isGameOver;
    private boolean isInitialized;
    private int playerNumTurn;
    private static final int dotPlayer1 = 1;
    private static final int dotPlayer2 = 2;
    private BufferedImage xImage;
    private BufferedImage oImage;

    public GameMap() {
        isInitialized = false;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });
        try {
            xImage = ImageIO.read(getClass().getResource("/X.png"));
            oImage = ImageIO.read(getClass().getResource("/0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update(MouseEvent e) {
        if (isGameOver || !isInitialized) {
            return;
        }
        if (!playerTurn(e)) {
            return;
        }

        if (gameMode == MODE_VS_HUMAN) {
            if (playerNumTurn == 2) {
                if (checkGame(dotPlayer1, STATE_WIN_HUMAN)) {
                    return;
                }
            } else {
                if (checkGame(dotPlayer2, STATE_WIN_HUMAN)) {
                    return;
                }
            }
        } else {
            if (checkGame(DOT_HUMAN, STATE_WIN_HUMAN)) {
                return;
            }
            if (checkGame(DOT_COMPUTER, STATE_WIN_COMPUTER)) {
                return;
            }
        }

        if (gameMode == MODE_VS_COMPUTER && !isGameOver) {
            computerTurn();
            repaint();
        }
    }

    private boolean playerTurn(MouseEvent event) {
        int cellX = event.getX() / cellWidth;
        int cellY = event.getY() / cellHeight;

        if (!isCellValid(cellX, cellY) || !isCellEmpty(cellX, cellY)) {
            return false;
        }

        if (gameMode == MODE_VS_HUMAN) {
            if (playerNumTurn == 1) {
                field[cellX][cellY] = dotPlayer1;
                playerNumTurn = 2; // Switch to Player 2
            } else {
                field[cellX][cellY] = dotPlayer2;
                playerNumTurn = 1; // Switch back to Player 1
            }
        } else {
            field[cellX][cellY] = DOT_HUMAN; // Default for single-player mode
        }

        repaint();
        return true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        if (!isInitialized) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        cellWidth = width / fieldSizeX;
        cellHeight = height / fieldSizeY;
        g.setColor(Color.BLACK);

        // Draw grid
        for (int i = 0; i < fieldSizeX; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, width, y);
        }
        for (int i = 0; i < fieldSizeY; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, height);
        }

        // Draw the X and O images
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isCellEmpty(x, y)) {
                    continue;
                }
                if (field[x][y] == DOT_HUMAN) {
                    g.drawImage(xImage, x * cellWidth, y * cellHeight, cellWidth, cellHeight, null);
                } else {
                    g.drawImage(oImage, x * cellWidth, y * cellHeight, cellWidth, cellHeight, null);
                }
            }
        }

        if (isGameOver) {
            showGameOverMessage(g);
        }
    }

    private void showGameOverMessage(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, getHeight() / 2 - 60, getWidth(), 120);
        g.setColor(Color.ORANGE);
        g.setFont(new Font("Arial", Font.BOLD, 60));
        String message = switch (stateGameOver) {
            case STATE_DRAW -> "DRAW";
            case STATE_WIN_HUMAN -> "HUMAN WINS!";
            case STATE_WIN_COMPUTER -> "COMPUTER WINS!";
            default -> "";
        };
        g.drawString(message, getWidth() / 4, getHeight() / 2);
    }

    public void startNewGame(int gameMode, int fieldSize, int winLength) {
        this.gameMode = gameMode;
        this.fieldSizeX = fieldSize;
        this.fieldSizeY = fieldSize;
        this.winLength = winLength;
        this.field = new int[fieldSizeX][fieldSizeY];
        isInitialized = true;
        isGameOver = false;
        repaint();
    }

    private boolean checkGame(int dot, int state) {
        if (checkWin(dot)) {
            stateGameOver = state;
            isGameOver = true;
            repaint();
            return true;
        }
        if (checkDraw()) {
            stateGameOver = STATE_DRAW;
            isGameOver = true;
            repaint();
            return true;
        }
        return false;
    }

    private boolean isCellValid(int x, int y) {
        return x >= 0 && y >= 0 && x < fieldSizeX && y < fieldSizeY;
    }

    private boolean isCellEmpty(int x, int y) {
        return field[x][y] == DOT_EMPTY;
    }

    private void computerTurn() {
        if (makeStrategicMove(DOT_COMPUTER, winLength - 1)) return;
        if (makeStrategicMove(DOT_HUMAN, winLength - 1)) return;
        makeRandomMove();
        repaint();
    }

    private boolean makeStrategicMove(int dot, int length) {
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

    private boolean checkAndPlaceDot(int dot, int length, int startX, int startY, int dx, int dy) {
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
            field[startX][startY] = DOT_COMPUTER;
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
        field[x][y] = DOT_COMPUTER;
    }

    private boolean checkDraw() {
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if (isCellEmpty(x, y)) return false;
            }
        }
        return true;
    }

    private boolean checkWin(int dot) {
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if (checkLine(dot, x, y, 1, 0) || checkLine(dot, x, y, 0, 1) ||
                        checkLine(dot, x, y, 1, 1) || checkLine(dot, x, y, 1, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkLine(int dot, int startX, int startY, int dx, int dy) {
        int endX = startX + (winLength - 1) * dx;
        int endY = startY + (winLength - 1) * dy;
        if (!isCellValid(endX, endY)) return false;

        for (int i = 0; i < winLength; i++) {
            if (field[startX + i * dx][startY + i * dy] != dot) {
                return false;
            }
        }
        return true;
    }
}