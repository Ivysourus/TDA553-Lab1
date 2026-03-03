package org.tda553group22.lab3.core;

import org.tda553group22.lab3.math.Vector2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

class CarWorkshop<T extends Car> implements Workshop<T> {
    private Vector2 pos;

    private final ArrayList<Integer> servicedCars = new ArrayList<>();
    private final CanLoadHelperUnordered<T> canLoadHelper;
    private final Class<T> supportedType;

    private static final double range = 30;
    private static final int serviceTimeMs = 5000;

    public CarWorkshop(Vector2 pos, int capacity, Class<T> supportedType) {
        this.pos = pos;
        canLoadHelper = new CanLoadHelperUnordered<>(capacity);
        this.supportedType = supportedType;
    }

    @Override
    public double getRange() {
        return range;
    }

    @Override
    public boolean withinRange(Vector2 pos) {
        return WorkshopWithinRangeHelper.withinRange(this.pos, pos, range);
    }

    @Override
    public boolean canAccept(Loadable load) {
        return supportedType.isInstance(load);
    }

    @Override
    public void load(T load) {
        if (servicedCars.contains(load.hashCode())) {
            return;
        }

        load.stopEngine();
        load.setState(new EngineVehicleLoaded(load));
        canLoadHelper.load(load);

        Timer timer = new Timer(serviceTimeMs, new TimerListener<T>(load, this));
        timer.setRepeats(false);
        timer.start();
    }

    @Override
    public void unload(T load) {
        servicedCars.add(load.hashCode());
        load.setState(new EngineVehicleStopped(load));
        canLoadHelper.unload(load);
    }

    @Override
    public Vector2 getPos() {
        return pos;
    }

    @Override
    public void setPos(Vector2 pos) {
        this.pos = pos;
    }

    private static class TimerListener<T extends Car> implements ActionListener {
        private final T load;
        private final Workshop<T> workshop;

        public TimerListener(T load, Workshop<T> workshop) {
            this.load = load;
            this.workshop = workshop;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            workshop.unload(load);
        }
    }
}
