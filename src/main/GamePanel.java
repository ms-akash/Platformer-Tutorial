package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.JPanel;
import java.awt.Graphics;

public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private float xDelta = 100f, yDelta = 100f;
    private float xDir = 0.003f, yDir = 0.003f;
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

    public void updateRectangle() {
        this.xDelta += xDir;
        if(this.xDelta > 1920 || this.xDelta < 0)
            this.xDir *= -1;

        this.yDelta += yDir;
        if(this.yDelta > 1080 || this.yDelta < 0)
            this.yDir *= -1;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        updateRectangle();

        g.fillRect((int) xDelta, (int) yDelta, 500, 200);

        frames++;

        if (System.currentTimeMillis() - lastChecked > 1000) {
            lastChecked = System.currentTimeMillis();
            System.out.println("FPS: " + frames);
            frames = 0;
        }

        repaint();
    }
}
