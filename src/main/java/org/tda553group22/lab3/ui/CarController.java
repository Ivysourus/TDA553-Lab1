package org.tda553group22.lab3.ui;

import org.tda553group22.lab3.core.Workshop;
import org.tda553group22.lab3.core.WorkshopFactory;
import org.tda553group22.lab3.core.Car;
import org.tda553group22.lab3.core.CarFactory;
import org.tda553group22.lab3.core.Loadable;
import org.tda553group22.lab3.math.Vector2;
import org.tda553group22.lab3.ui.model.Model;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.Timer;

final class CarController {

    private final Model model;
    private final CarView view;

    public static CarController instance;

    public CarController(String title, Dimension size, Model model) {
        if (instance != null) {
            throw new RuntimeException("An instance of CarController already exists");
        }
        instance = this;

        this.model = model;
        view = new CarView(title, size);

        model.addUpdateObserver(view);

        // The delay (ms) corresponds to 20 updates a sec (hz)
        int delay = 50;
        Timer timer = new Timer(delay, new TimerListener());
        timer.start();
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.update();
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
        view.addSprite(sprite);
        model.addObservedCar(car, sprite);
    }

    private void addWorkshop(Workshop<? extends Loadable> workshop, BufferedImage image) {
        Sprite sprite = new Sprite(workshop.getPos(), 0, image);
        view.addSprite(sprite);
        model.addObservedWorkshop(workshop, sprite);
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

    public void raiseBedAllCars() {
        model.raiseBedAllCars();
    }

    public void lowerBedAllCars() {
        model.lowerBedAllCars();
    }

    public void addCarRandom() {
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

    public void removeCarRandom() {
        int carCount = model.getCarCount();
        if (carCount != 0) {
            int randomIndex = (int)(Math.random() * carCount);
            model.removeCar(randomIndex);
        }
    }
}
