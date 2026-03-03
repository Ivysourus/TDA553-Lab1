package org.tda553group22.lab3.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;

class GasPanel extends JPanel {
    public GasPanel(Dimension minSize, ChangeListener listener) {
        SpinnerModel spinnerModel = new SpinnerNumberModel(
                0, // initial value
                0, // min
                100, // max
                1); // step
        JSpinner gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(listener);

        this.setLayout(new BorderLayout());
        this.setMinimumSize(minSize);
        this.add(new JLabel("Amount of gas"), BorderLayout.PAGE_START);
        this.add(gasSpinner, BorderLayout.CENTER);
    }
}
