package org.tda553group22.lab3.ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.tda553group22.lab3.ui.model.UpdateObserver;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class CarView extends JFrame implements UpdateObserver {
    private final int preferredSizeX;
    private final int preferredSizeY;

    private final JPanel drawPanel = new JPanel();
    private final JPanel controlPanel = new JPanel();

    private final JPanel gasPanel = new JPanel();
    private final JLabel gasLabel = new JLabel("Amount of gas");

    private final JButton gasButton = new JButton("Gas");
    private final JButton brakeButton = new JButton("Brake");
    private final JButton turboOnButton = new JButton("Saab Turbo on");
    private final JButton turboOffButton = new JButton("Saab Turbo off");
    private final JButton liftBedButton = new JButton("Scania Raise Lift Bed");
    private final JButton lowerBedButton = new JButton("Scania Lower Lift Bed");

    private final JButton startButton = new JButton("Start all cars");
    private final JButton stopButton = new JButton("Stop all cars");

    private final JButton addCarRandomButton = new JButton("Adds random car");
    private final JButton removeCarRandomButton = new JButton("Removes random car");

    private int gasAmount = 0;

    public CarView(String title, Dimension size) {
        this.preferredSizeX = (int) Math.round(size.getWidth());
        this.preferredSizeY = (int) Math.round(size.getHeight());

        this.setTitle(title);
        this.setPreferredSize(size);
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.initComponents();
    }

    @Override
    public void actOnUpdate() {
        this.repaint();
    }

    public void addSprite(Sprite sprite) {
        drawPanel.add(sprite);

        this.pack();
        this.repaint();
    }


    private void initComponents() {
        this.initDrawPanel();
        this.initGasPanel();
        this.initControlPanel();
        this.initButtons();

        this.pack();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame on the screen
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initDrawPanel() {
        drawPanel.setDoubleBuffered(true);
        drawPanel.setPreferredSize(new Dimension(this.preferredSizeX, this.preferredSizeY - 240));
        drawPanel.setBackground(Color.white);
        this.add(drawPanel);
    }

    private void initGasPanel() {
        SpinnerModel spinnerModel = new SpinnerNumberModel(
                0,   // initial value
                0,   // min
                100, // max
                1);  // step
        JSpinner gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(e -> gasAmount = (int) ((JSpinner) e.getSource()).getValue());

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);
    }

    private void initControlPanel() {
        controlPanel.setLayout(new GridLayout(2, 4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.setPreferredSize(new Dimension((this.preferredSizeX / 2) + 4, 200));
        controlPanel.setBackground(Color.CYAN);

        this.add(controlPanel);
    }

    private void initButtons() {
        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(this.preferredSizeX / 5 - 15, 200));
        this.add(startButton);

        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(this.preferredSizeX / 5 - 15, 200));
        this.add(stopButton);

        addCarRandomButton.setBackground(Color.cyan);
        addCarRandomButton.setForeground(Color.blue);
        addCarRandomButton.setPreferredSize(new Dimension(this.preferredSizeX / 5 - 15, 200));
        this.add(addCarRandomButton);

        removeCarRandomButton.setBackground(Color.cyan);
        removeCarRandomButton.setForeground(Color.blue);
        removeCarRandomButton.setPreferredSize(new Dimension(this.preferredSizeX / 5 - 15, 200));
        this.add(removeCarRandomButton);

        gasButton.addActionListener(_ -> CarController.instance.gasAllCars(gasAmount));

        brakeButton.addActionListener(_ -> CarController.instance.brakeAllCars(gasAmount));

        startButton.addActionListener(_ -> CarController.instance.startAllEngines());

        stopButton.addActionListener(_ -> CarController.instance.stopAllEngines());

        addCarRandomButton.addActionListener(_ -> CarController.instance.addCarRandom());

        removeCarRandomButton.addActionListener(_ -> CarController.instance.removeCarRandom());

        turboOnButton.addActionListener(_ -> CarController.instance.setTurboOnAllCars());

        turboOffButton.addActionListener(_ -> CarController.instance.setTurboOffAllCars());

        liftBedButton.addActionListener(_ -> CarController.instance.raiseBedAllCars());

        lowerBedButton.addActionListener(_ -> CarController.instance.lowerBedAllCars());
    }
}
