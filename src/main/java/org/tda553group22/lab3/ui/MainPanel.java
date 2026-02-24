package org.tda553group22.lab3.ui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

class MainPanel extends JPanel {
    public MainPanel(Dimension size) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(size);
        this.setBackground(Color.white);
    }
}
