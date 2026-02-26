package org.tda553group22.lab3.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import org.tda553group22.lab3.core.AngleFunctions;
import org.tda553group22.lab3.core.PositionFunctions;
import org.tda553group22.lab3.math.Vector2;
import org.tda553group22.lab3.mathawtextensions.Vector2AwtExtensions;
import org.tda553group22.lab3.ui.model.MoveObserver;

class Sprite extends JPanel implements PositionFunctions, AngleFunctions, HasImage, MoveObserver {
    private double angle;
    private BufferedImage image;

    public Sprite(Vector2 pos, double angle, BufferedImage image) {
        this.setPos(pos);
        this.angle = angle;
        this.image = image;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
        this.setBackground(Color.white);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }

    @Override
    public Vector2 getPos() {
        return Vector2AwtExtensions.fromPoint(this.getLocation());
    }

    @Override
    public void setPos(Vector2 pos) {
        this.setLocation(Vector2AwtExtensions.toPoint(pos));
    }

    @Override
    public double getAngle() {
        return angle;
    }

    @Override
    public void setAngle(double angle) {
        this.angle = angle;
    }

    @Override
    public BufferedImage getImage() {
        return image;
    }

    @Override
    public void actOnMove(Vector2 pos, double angle) {
        this.setPos(pos);
        this.setAngle(angle);
    }

    @Override
    public void actOnRemove() {
        this.setVisible(false);
    }
}
