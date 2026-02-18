import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {
    BufferedImage volvoWorkshopImage;
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;

    Point volvoWorkshopPoint = new Point();
    Point volvoPoint = new Point();
    Point saabPoint = new Point();
    Point scaniaPoint = new Point();

    void moveit(HasPosition hasPos) {
        Vector2 pos = hasPos.getPos();
        int x = (int) Math.round(pos.x);
        int y = (int) Math.round(pos.y);
        if (hasPos instanceof WorkshopWithPosition) {
            volvoWorkshopPoint.x = x;
            volvoWorkshopPoint.y = y;
        } else if (hasPos instanceof Volvo240) {
            volvoPoint.x = x;
            volvoPoint.y = y;
        } else if (hasPos instanceof Saab95) {
            saabPoint.x = x;
            saabPoint.y = y;
        } else if (hasPos instanceof Scania) {
            scaniaPoint.x = x;
            scaniaPoint.y = y;
        }
    }

    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.white);

        try {
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
        g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null);
        g.drawImage(saabImage, saabPoint.x, saabPoint.y, null);
        g.drawImage(scaniaImage, scaniaPoint.x, scaniaPoint.y, null);
    }
}
