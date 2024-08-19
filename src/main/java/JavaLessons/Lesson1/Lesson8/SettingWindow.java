package JavaLessons.Lesson1.Lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingWindow extends JFrame {
    private static final int windowWidth = 360;
    private static final int windowHeight = 300;
    private static final int minWinLength = 3;
    private static final int minFieldSize = 3;
    private static final int maxFieldSize = 15;
    private static final String winLengthPrefix = "Win length: ";
    private static final String fieldSizePrefix = "Field size:";

    private JRadioButton humanVsComputer;
    private JRadioButton humanVsHuman;
    private JTextField textWinLength;
    private JTextField textFieldSize;
    private GameWindow gameWindow;

    public SettingWindow(GameWindow gameWindow) {
        this. gameWindow = gameWindow;
        setSize(windowWidth, windowHeight);
        setLocationRelativeTo(gameWindow);
        setResizable(false);
        setTitle("New game settings");
        setLayout (new GridLayout(10, 1));
        chooseGameMode();
        chooseFieldAndWinSize();
        Button btnStart = new Button("Start new game");
        btnStart.addActionListener(e -> submitSettings(gameWindow));
        add(btnStart);


    }

    private void chooseFieldAndWinSize() {
        JLabel labelFieldSize = new JLabel(fieldSizePrefix + minFieldSize);
        JLabel labelWinLength = new JLabel(winLengthPrefix + minWinLength);
        textFieldSize = new JTextField(Integer.toString(maxFieldSize));
        textWinLength = new JTextField(Integer.toString(minWinLength));

        textFieldSize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentValue;
                try {
                    currentValue = Integer.parseInt(textFieldSize.getText());
                    if (currentValue < minFieldSize || currentValue > maxFieldSize) {
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException ex) {
                    currentValue = maxFieldSize;
                    textFieldSize.setText(Integer.toString(currentValue));
                }
                labelFieldSize.setText(fieldSizePrefix + currentValue);
                textWinLength.setText(Integer.toString(Math.min(currentValue, Integer.parseInt(textWinLength.getText()))));
            }
        });

        textWinLength.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentValue;
                try {
                    currentValue = Integer.parseInt(textWinLength.getText());
                    int maxValue = Integer.parseInt(textFieldSize.getText());
                    if (currentValue < minWinLength || currentValue > maxValue) {
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException ex) {
                    currentValue = minWinLength;
                    textWinLength.setText(Integer.toString(currentValue));
                }
                labelWinLength.setText(winLengthPrefix + currentValue);
            }
        });

        add(new JLabel("Choose field size"));
        add(labelFieldSize);
        add(textFieldSize);
        add(new JLabel("Choose win length"));
        add(labelWinLength);
        add(textWinLength);
    }


    private void chooseGameMode() {
        add (new JLabel ("Choose game mode:"));
        humanVsComputer = new JRadioButton ("Human versus AI",true);
        humanVsHuman = new JRadioButton("Human versus human");
        ButtonGroup gameMode = new ButtonGroup();
        gameMode.add(humanVsComputer);
        gameMode.add(humanVsHuman);
        add(humanVsComputer);
        add(humanVsHuman);
    }

    private void submitSettings(GameWindow gameWindow) {
        int gameMode;
        if (humanVsComputer.isSelected()){
            gameMode = GameMap.MODE_VS_COMPUTER;
        } else {
                gameMode = GameMap.MODE_VS_HUMAN;
    }
        int fieldSize = Integer.parseInt(textFieldSize.getText());
        int winLength = Integer.parseInt(textWinLength.getText());
    gameWindow.startNewGame(gameMode, fieldSize, winLength);
    setVisible(false);

}
}
