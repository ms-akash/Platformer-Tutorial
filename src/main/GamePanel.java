package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private float xDelta = 100f, yDelta = 100f;
    private float xDir = 1f, yDir = 1f;
    private Color color = new Color(255, 255, 255);
    private Random random;

    public GamePanel() {
        mouseInputs = new MouseInputs(this);
        random = new Random();

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
        if (this.xDelta > 1920 || this.xDelta < 0) {
            this.xDir *= -1;
            color = getRandomColor();
        }

        this.yDelta += yDir;
        if (this.yDelta > 1080 || this.yDelta < 0) {
            this.yDir *= -1;
            color = getRandomColor();
        }
    }

    public Color getRandomColor() {
        int red = random.nextInt(255);
        int blue = random.nextInt(255);
        int green = random.nextInt(255);

        return new Color(red, green, blue);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        updateRectangle();

        g.setColor(color);
        g.fillRect((int) xDelta, (int) yDelta, 500, 200);
    }
}
