package org.tda553group22.lab3.core;

import org.tda553group22.lab3.math.Vector2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class CarWorkshop<T extends Car> implements Workshop<T> {
    private final ArrayList<int> fixedCars = new ArrayList<>();
    private Vector2 pos;
    private final CanLoadHelperUnordered<T> canLoadHelper;
    private final Class<T> supportedType;
    private static final double range = 30;
    private static final int serviceTimeMs = 10000;

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
    public boolean isWithinRange(Vector2 pos) {
        return WorkshopWithinRangeHelper.isWithinRange(this.pos, pos, range);
    }

    @Override
    public boolean canAccept(Loadable load) {
        return supportedType.isInstance(load);
    }

    @Override
    public void load(T load) {
        if (!fixedCars.contains(load.hashCode())){
            load.stopEngine();
            load.state = new EngineVehicleLoaded();
            canLoadHelper.load(load);
        }

        Timer timer = new Timer(serviceTimeMs, new TimerListener(load, this));
        timer.setRepeats(false);
        timer.start();
    }

    @Override
    public void unload(T load) {
        fixedCars.add(load.hashCode());
        load.state = new EngineVehicleStopped();
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

    private static class TimerListener implements ActionListener {
        private final Car car;
        private final Workshop<Car> workshop;

        public TimerListener(Car car, Workshop<? extends Car> workshop) {
            this.car = car;
            this.workshop = (Workshop<Car>) workshop;
        }

        @Override
        public void actionPerformed(ActionEvent e){
            workshop.unload(car);
        }
    }
}
