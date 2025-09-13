package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.JPanel;
import java.awt.Graphics;

public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private int xDelta = 0, yDelta = 0;

    public GamePanel() {
        mouseInputs = new MouseInputs();

        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void changeXDelta(int xDelta) {
        this.xDelta += xDelta;
        repaint();
    }

    public void changeYDelta(int yDelta) {
        this.yDelta += yDelta;
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.fillRect(100 + xDelta, 100 + yDelta, 500, 200);
    }
}
