package org.tda553group22.lab3.ui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

class ControlPanel extends JPanel {
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

    private int gasAmount;

    public ControlPanel() {
        this.setLayout(new GridLayout(2, 5));

        this.add(gasButton, 0);
        this.add(turboOnButton, 1);
        this.add(liftBedButton, 2);
        this.add(startButton, 3);
        this.add(addCarRandomButton, 4);
        this.add(brakeButton, 5);
        this.add(turboOffButton, 6);
        this.add(lowerBedButton, 7);
        this.add(stopButton, 8);
        this.add(removeCarRandomButton, 9);

        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);

        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);

        addCarRandomButton.setBackground(Color.cyan);
        addCarRandomButton.setForeground(Color.blue);

        removeCarRandomButton.setBackground(Color.cyan);
        removeCarRandomButton.setForeground(Color.blue);

        gasButton.addActionListener(_ -> CarController.instance.gasAllCars(gasAmount));
        brakeButton.addActionListener(_ -> CarController.instance.brakeAllCars(gasAmount));
        turboOnButton.addActionListener(_ -> CarController.instance.setTurboOnAllCars());
        turboOffButton.addActionListener(_ -> CarController.instance.setTurboOffAllCars());
        liftBedButton.addActionListener(_ -> CarController.instance.raiseBedAllCars());
        lowerBedButton.addActionListener(_ -> CarController.instance.lowerBedAllCars());
        startButton.addActionListener(_ -> CarController.instance.startAllEngines());
        stopButton.addActionListener(_ -> CarController.instance.stopAllEngines());
        addCarRandomButton.addActionListener(_ -> CarController.instance.addCarRandom());
        removeCarRandomButton.addActionListener(_ -> CarController.instance.removeCarRandom());
    }

    public void setGasAmount(int gasAmount) {
        this.gasAmount = gasAmount;
    }
}
