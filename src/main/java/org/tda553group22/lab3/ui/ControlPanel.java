package org.tda553group22.lab3.ui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

class ControlPanel extends JPanel {
    private int gasAmount;

    public ControlPanel() {
        this.setLayout(new GridLayout(2, 5));

        JButton gasButton = new JButton("Gas");
        this.add(gasButton, 0);
        JButton turbosOnButton = new JButton("Turbos on");
        this.add(turbosOnButton, 1);
        JButton raiseTruckBedsButton = new JButton("Raise truck beds");
        this.add(raiseTruckBedsButton, 2);
        JButton startEnginesButton = new JButton("Start engines");
        this.add(startEnginesButton, 3);
        JButton addRandomCarButton = new JButton("Add random car");
        this.add(addRandomCarButton, 4);
        JButton brakeButton = new JButton("Brake");
        this.add(brakeButton, 5);
        JButton turbosOffButton = new JButton("Turbos off");
        this.add(turbosOffButton, 6);
        JButton lowerTruckBedsButton = new JButton("Lower truck beds");
        this.add(lowerTruckBedsButton, 7);
        JButton stopEnginesButton = new JButton("Stop engines");
        this.add(stopEnginesButton, 8);
        JButton removeRandomCarButton = new JButton("Remove random car");
        this.add(removeRandomCarButton, 9);

        Color accentColor = Color.blue;
        gasButton.setForeground(accentColor);
        turbosOnButton.setForeground(accentColor);
        raiseTruckBedsButton.setForeground(accentColor);
        startEnginesButton.setForeground(accentColor);

        addRandomCarButton.setForeground(Color.green);
        removeRandomCarButton.setForeground(Color.red);

        gasButton.addActionListener(_ -> CarController.instance.gasAllCars(gasAmount));
        brakeButton.addActionListener(_ -> CarController.instance.brakeAllCars(gasAmount));
        turbosOnButton.addActionListener(_ -> CarController.instance.setTurboOnAllCars());
        turbosOffButton.addActionListener(_ -> CarController.instance.setTurboOffAllCars());
        raiseTruckBedsButton.addActionListener(_ -> CarController.instance.raiseTruckBedAllCars());
        lowerTruckBedsButton.addActionListener(_ -> CarController.instance.lowerTruckBedAllCars());
        startEnginesButton.addActionListener(_ -> CarController.instance.startAllEngines());
        stopEnginesButton.addActionListener(_ -> CarController.instance.stopAllEngines());
        addRandomCarButton.addActionListener(_ -> CarController.instance.addCarRandom());
        removeRandomCarButton.addActionListener(_ -> CarController.instance.removeCarRandom());
    }

    public void setGasAmount(int gasAmount) {
        this.gasAmount = gasAmount;
    }
}
