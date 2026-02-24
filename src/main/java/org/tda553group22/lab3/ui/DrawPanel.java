package org.tda553group22.lab3.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

class DrawPanel extends JPanel {
    private final BufferedImage image;

    private Point pos = new Point();

    void setPos(Point pos) {
        this.pos = pos;
    }

    public DrawPanel(Dimension size, Point pos, BufferedImage image) {
        this.image = image;
        this.pos = pos;
        this.setDoubleBuffered(true);
        this.setPreferredSize(size);
        this.setBackground(Color.white);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, pos.x, pos.y, null);
    }
}
