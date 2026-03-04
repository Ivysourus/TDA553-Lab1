package org.tda553group22.lab3.ui;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JSpinner;

import org.tda553group22.lab3.ui.model.EverythingObserver;

import java.awt.Dimension;
import java.awt.Toolkit;

class CarView extends JFrame {
    private final int boundsX;
    private final int boundsY;

    private Box main;
    private Box footer;
    private DrawPanel drawPanel;
    private ControlPanel controlPanel;

    public CarView(String title, Dimension size, Dimension drawPanelSize) {
        this.boundsX = (int) Math.round(size.getWidth());
        this.boundsY = (int) Math.round(size.getHeight());

        this.setTitle(title);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(dim.width / 2 - boundsX / 2, dim.height / 2 - boundsY / 2, boundsX, boundsY);

        this.initComponents(drawPanelSize);

        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public EverythingObserver makeObserver() {
        return drawPanel.makeObserver();
    }

    public void addPaintable(Paintable paintable) {
        drawPanel.addPaintable(paintable);
    }

    private void initComponents(Dimension drawPanelSize) {
        this.initMain(drawPanelSize);

        this.pack();
    }

    private void initMain(Dimension drawPanelSize) {
        main = Box.createVerticalBox();
        this.add(main);

        this.initDrawPanel(drawPanelSize);

        this.initFooter();
    }

    private void initDrawPanel(Dimension size) {
        drawPanel = new DrawPanel(size);
        main.add(drawPanel);
    }

    private void initFooter() {
        footer = Box.createHorizontalBox();
        footer.setPreferredSize(new Dimension(boundsX, 200));
        main.add(footer);

        this.initGasPanel();
        this.initControlPanel();
    }

    private void initGasPanel() {
        footer.add(new GasPanel(new Dimension(100, 50),
                e -> controlPanel.setGasAmount((int) ((JSpinner) e.getSource()).getValue())));
    }

    private void initControlPanel() {
        controlPanel = new ControlPanel();
        footer.add(controlPanel);
    }
}
