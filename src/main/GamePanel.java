package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.JPanel;
import java.awt.Graphics;

public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;

    public GamePanel() {
        mouseInputs = new MouseInputs();

        addKeyListener(new KeyboardInputs());
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.fillRect(100, 100, 500, 200);
    }
}
