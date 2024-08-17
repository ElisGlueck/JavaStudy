package JavaLessons.Lesson1.Lesson8;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    private static final int windowHeight = 640;
    private static final int windowWidth = 600;
    private GameMap gameMap;

    public GameWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(windowWidth, windowHeight);
        setLocationRelativeTo(null);
        setTitle("TicTacToe");
        setResizable(false);
        JButton btnYes = new JButton("Yes");
        add(btnYes, BorderLayout.CENTER);
        JButton btnExit = new JButton("Exit");
        add(btnExit, BorderLayout.EAST);

        JLabel label = new Label("Do you want to play?");
        label.setFont(new Font("Arial", Font.BOLD, 60));
        add(label, BorderLayout.NORTH);

        gameMap = new GameMap();
        SettingWindow settings = new SettingWindow(this);
        add(gameMap, BorderLayout.CENTER);
        setVisible(true);
        btnYes.addActionListener(e -> settings.setVisible(true));
        btnExit.addActionListener(e -> System.exit(0));

    }

    public void startGame(int gameMode, int fieldSize, int winLength) {
        System.out.printf("Mode: %s, Field size: %d, Win length: %d\n", gameMode, fieldSize, winLength);
    }




}
