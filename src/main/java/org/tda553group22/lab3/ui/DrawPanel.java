package org.tda553group22.lab3.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.tda553group22.lab3.ui.model.EverythingObserver;
import org.tda553group22.lab3.ui.model.ObserverFactory;

class DrawPanel extends JPanel {
    private List<Paintable> paintables = new ArrayList<>();

    public DrawPanel(Dimension size) {
        this.setDoubleBuffered(true);
        this.setMinimumSize(size);
        this.setPreferredSize(size);
        this.setMaximumSize(size);
        this.setBackground(Color.white);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Paintable p : paintables) {
            p.paint(g);
        }
    }

    public EverythingObserver makeObserver() {
        return ObserverFactory.makeUpdateObserver(() -> {
            this.repaint();
        });
    }

    public void addPaintable(Paintable paintable) {
        paintables.add(paintable);
    }
}
