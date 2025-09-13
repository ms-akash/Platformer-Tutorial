package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private float xDelta = 100f, yDelta = 100f;

    public GamePanel() {
        mouseInputs = new MouseInputs(this);

        setPannelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void setPannelSize() {
        Dimension screenSize = new Dimension(1280, 800);
        setPreferredSize(screenSize);
    }

    public void changeXDelta(int xDelta) {
        this.xDelta += xDelta;
    }

    public void changeYDelta(int yDelta) {
        this.yDelta += yDelta;
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
