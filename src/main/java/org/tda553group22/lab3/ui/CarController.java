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

/*
* This class represents the Controller part in the MVC pattern.
* Its responsibilities are to listen to the View and responds in an appropriate manner by
* modifying the model state and the updating the view.
 */
final class CarController {
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private final Timer timer = new Timer(delay, new TimerListener());

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

    void addCarRandom() {
        if (cars.size() < 10) {
            int roll = (int)(Math.random() * 4);
            switch (roll) {
                case 0:
                    cars.add(CarFactory.createVolvo240(Vector2.zero()));
                    break;
                case 1:
                    cars.add(CarFactory.createScania(Vector2.zero()));
                    break;
                case 2:
                    cars.add(CarFactory.createSaab95(Vector2.zero()));
                    break;
            }
        }
    }

    void removeCarRandom() {
        if (!cars.isEmpty()) {
            int size = cars.size();
            int randomNum = (int)(Math.random() * (size+1));
            cars.remove(randomNum);
        }
    }
}
