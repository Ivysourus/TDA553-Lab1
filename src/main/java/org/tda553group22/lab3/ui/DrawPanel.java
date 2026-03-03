package org.tda553group22.lab3.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.tda553group22.lab3.ui.model.UpdateObserver;

class DrawPanel extends JPanel implements UpdateObserver {
    private boolean dirty;
    private List<Sprite> sprites = new ArrayList<>();

    public DrawPanel(Dimension size) {
        this.setDoubleBuffered(true);
        this.setMinimumSize(size);
        this.setPreferredSize(size);
        this.setMaximumSize(size);
        this.setBackground(Color.white);
    }

    @Override
    public void actOnUpdate() {
        this.repaint();
        if (dirty) {
            dirty = false;
            this.revalidate();
        }
    }

    public void addSprite(Sprite sprite) {
        sprites.add(sprite);
        this.add(sprite);
        dirty = true;
    }
}
