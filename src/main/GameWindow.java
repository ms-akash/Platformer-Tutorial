package main;

import javax.swing.JFrame;

public class GameWindow {
    private JFrame frame;

    public GameWindow() {
        frame = new JFrame();

        frame.setSize(1920, 1080);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
