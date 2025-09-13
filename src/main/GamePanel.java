package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;

public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private float xDelta = 100f, yDelta = 100f;
    private BufferedImage img, subImage;

    public GamePanel() {
        mouseInputs = new MouseInputs(this);

        importImg();
        setPannelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void importImg() {
        InputStream is = getClass().getResourceAsStream("/player_sprites.png");
        try {
            img = ImageIO.read(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public void changeImgPosition(int x, int y) {
        xDelta = x;
        yDelta = y;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        subImage = img.getSubimage(1 * 64, 8 * 40, 64, 40);
        g.drawImage(subImage, (int) xDelta, (int) yDelta, 128, 80, null);
    }
}
