package org.tda553group22.lab3.ui;

import org.tda553group22.lab3.core.Workshop;
import org.tda553group22.lab3.core.WorkshopFactory;
import org.tda553group22.lab3.core.Car;
import org.tda553group22.lab3.core.CarFactory;
import org.tda553group22.lab3.core.Loadable;
import org.tda553group22.lab3.math.Vector2;
import org.tda553group22.lab3.ui.model.CarModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.Timer;

class CarController {
    private final CarModel model;
    private final CarView view;

    // The delay (seconds) corresponds to 20 updates a sec (hz)
    private static final double delay = 50d / 1000;

    public static CarController instance;

    public CarController(CarModel model, CarView view) {
        if (instance != null) {
            throw new RuntimeException("An instance of CarController already exists");
        }
        instance = this;

        this.model = model;
        this.view = view;

        model.addObserver(view.makeObserver());

        Timer timer = new Timer((int) (delay*1000), new TimerListener());
        timer.start();
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.update(delay);
        }
    }

    public void addVolvo240(Vector2 pos) {
        this.addCar(CarFactory.createVolvo240(pos), ResourcesHandler.volvoImage);
    }

    public void addSaab95(Vector2 pos) {
        this.addCar(CarFactory.createSaab95(pos), ResourcesHandler.saabImage);
    }

    public void addScania(Vector2 pos) {
        this.addCar(CarFactory.createScania(pos), ResourcesHandler.scaniaImage);
    }

    public void addVolvoWorkshop(Vector2 pos, int capacity) {
        this.addWorkshop(WorkshopFactory.createVolvoWorkshop(pos, capacity), ResourcesHandler.volvoWorkshopImage);
    }

    private void addCar(Car car, BufferedImage image) {
        Sprite sprite = new Sprite(car.getPos(), car.getAngle(), image);
        view.addPaintable(sprite);
        model.addObservedCar(car, sprite.makeObserver());
    }

    private void addWorkshop(Workshop<? extends Loadable> workshop, BufferedImage image) {
        Sprite sprite = new Sprite(workshop.getPos(), 0, image);
        view.addPaintable(sprite);
        model.addObservedWorkshop(workshop, sprite.makeObserver());
    }

    public void gasAllCars(int amount) {
        double adjAmount = ((double) amount) / 100;
        model.gasAllCars(adjAmount);
    }

    public void brakeAllCars(int amount) {
        double adjAmount = ((double) amount) / 100;
        model.brakeAllCars(adjAmount);
    }

    public void startAllEngines() {
        model.startAllEngines();
    }

    public void stopAllEngines() {
        model.stopAllEngines();
    }

    public void setTurboOnAllCars() {
        model.setTurboOnAllCars();
    }

    public void setTurboOffAllCars() {
        model.setTurboOffAllCars();
    }

    public void raiseTruckBedAllCars() {
        model.raiseBedAllCars();
    }

    public void lowerTruckBedAllCars() {
        model.lowerBedAllCars();
    }

    public void addRandomCar() {
        if (model.getCarCount() > 10) {
            return;
        }

        Vector2 pos = Vector2.randRange(model.getBoundsMin(), model.getBoundsMax());

        int roll = (int)(Math.random() * 4);
        switch (roll) {
            case 0:
                this.addVolvo240(pos);
                break;
            case 1:
                this.addSaab95(pos);
                break;
            case 2:
                this.addScania(pos);
                break;
        }
    }

    public void removeRandomCar() {
        int carCount = model.getCarCount();
        if (carCount != 0) {
            int randomIndex = (int)(Math.random() * carCount);
            model.removeCar(randomIndex);
        }
    }
}
