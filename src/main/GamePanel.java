package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.JPanel;
import java.awt.Graphics;

public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private int xDelta = 100, yDelta = 100;
    private int frames = 0;
    private long lastChecked = 0;

    public GamePanel() {
        mouseInputs = new MouseInputs(this);

        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void changeXDelta(int xDelta) {
        this.xDelta += xDelta;
    }

    public void changeYDelta(int yDelta) {
        this.yDelta += yDelta;
    }

    public void changeRectPosition(int x, int y) {
        this.xDelta = x;
        this.yDelta = y;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.fillRect(xDelta, yDelta, 500, 200);

        frames++;

        if (System.currentTimeMillis() - lastChecked > 1000) {
            lastChecked = System.currentTimeMillis();
            System.out.println("FPS: " + frames);
            frames = 0;
        }

        repaint();
    }
}
