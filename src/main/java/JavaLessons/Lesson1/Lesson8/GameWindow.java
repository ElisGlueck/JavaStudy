package JavaLessons.Lesson1.Lesson8;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    private final int WINDOW_WIDTH = 507;
    private final int WINDOW_HEIGHT = 555;
    private final SettingWindow settingsWindow;
    private final GameMap gameMap;

    public GameWindow() {
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);

        settingsWindow = new SettingWindow(this);
        gameMap = new GameMap();

        JButton btnStart = new JButton("Start new game");
        btnStart.addActionListener(e -> settingsWindow.setVisible(true));

        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(e -> System.exit(0));

        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(btnStart);
        panel.add(btnExit);

        add(panel, BorderLayout.SOUTH);
        add(gameMap, BorderLayout.CENTER);

        setVisible(true);
    }

    public void startNewGame(int gameMode, int fieldSize, int winLength) {
        gameMap.startNewGame(gameMode, fieldSize, winLength);
    }
}
