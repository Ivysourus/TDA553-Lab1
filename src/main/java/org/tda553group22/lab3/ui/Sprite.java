package org.tda553group22.lab3.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import org.tda553group22.lab3.core.HasAngle;
import org.tda553group22.lab3.core.HasPosition;
import org.tda553group22.lab3.math.Vector2;
import org.tda553group22.lab3.ui.model.EverythingObserver;
import org.tda553group22.lab3.ui.model.ObserverFactory;

class Sprite implements Paintable, HasPosition, HasAngle, HasImage {
    private Vector2 pos;
    private double angle;
    private boolean visible = true;

    private final BufferedImage image;

    public Sprite(Vector2 pos, double angle, BufferedImage image) {
        this.pos = pos;
        this.angle = angle;
        this.image = image;
    }

    public EverythingObserver makeObserver() {
        return ObserverFactory.makeCompositeObserver(new EverythingObserver[] {
                makeMoveObserver(),
                makeRemoveObserver()
        });
    }

    private EverythingObserver makeMoveObserver() {
        return ObserverFactory.makeMoveObserver((Vector2 pos, double angle) -> {
            setPos(pos);
            setAngle(angle);
        });
    }

    private EverythingObserver makeRemoveObserver() {
        return ObserverFactory.makeRemoveObserver(() -> {
            visible = false;
        });
    }

    public boolean getVisible() {
        return visible;
    }

    private void setPos(Vector2 pos) {
        this.pos = pos;
    }

    private void setAngle(double angle) {
        this.angle = angle;
    }

    @Override
    public void paint(Graphics g) {
        if (visible) {
            g.drawImage(image, (int) Math.round(pos.x), (int) Math.round(pos.y), null);
        }
    }

    @Override
    public Vector2 getPos() {
        return pos;
    }

    @Override
    public double getAngle() {
        return angle;
    }

    @Override
    public BufferedImage getImage() {
        return image;
    }
}
