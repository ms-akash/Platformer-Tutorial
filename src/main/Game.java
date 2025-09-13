package main;

public class Game implements Runnable {
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private final int FPS_SET = 120;
    Thread gameLoopThread;

    public Game() {
        gamePanel = new GamePanel();
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
        startGameLoop();
    }

    public void startGameLoop() {
        gameLoopThread = new Thread(this);
        gameLoopThread.start();
    }

    @Override
    public void run() {
        double timePerFrame = 1000000000.0 / FPS_SET;
        long now = System.nanoTime();
        long lastTime = System.nanoTime();

        while (true) {
            now = System.nanoTime();
            if (now - lastTime >= timePerFrame) {
                gamePanel.repaint();
                lastTime = now;
            }
        }
    }
}
