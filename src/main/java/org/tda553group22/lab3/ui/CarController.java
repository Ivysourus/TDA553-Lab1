package org.tda553group22.lab3.ui;

import org.tda553group22.lab3.main.Volvo240;
import org.tda553group22.lab3.main.Scania;
import org.tda553group22.lab3.main.Saab95;
import org.tda553group22.lab3.main.WorkshopWithPosition;
import org.tda553group22.lab3.main.Car;
import org.tda553group22.lab3.math.Vector2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

/*
* This class represents the Controller part in the MVC pattern.
* Its responsibilities are to listen to the View and responds in an appropriate manner by
* modifying the model state and the updating the view.
 */
public class CarController {
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    List<Car> cars = new ArrayList<>();
    WorkshopWithPosition<Volvo240> volvoWorkshop;

    public static void main(String[] args) {
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        cc.cars.add(new Scania());
        cc.cars.add(new Saab95());
        cc.volvoWorkshop = new WorkshopWithPosition<>(1, new Vector2(300, 0));

        for (int i = 0; i < cc.cars.size(); i++) {
            cc.cars.get(i).setPos(new Vector2(0, i * 100));
        }

        cc.frame = new CarView("CarSim 1.0", cc);

        // Only need to move the workshop once since it cannot move
        cc.frame.drawPanel.moveit(cc.volvoWorkshop);

        cc.timer.start();
    }

    /*
     * Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                car.move();
                frame.drawPanel.moveit(car);
                frame.drawPanel.repaint();

                Vector2 pos = car.getPos();
                Vector2 min = Vector2.zero();
                Vector2 max = new Vector2(frame.getSize().getWidth(), frame.getSize().getHeight())
                        .sub(new Vector2(100, 0));
                Vector2 clampedPos = pos.clamp(min, max);
                if (!clampedPos.equals(pos)) {
                    car.setPos(clampedPos);
                    car.stopEngine();
                    car.turnLeft();
                    car.turnLeft();
                    car.startEngine();
                }

                if (car instanceof Volvo240 volvo &&
                        car.getPos().distance(volvoWorkshop.getPos()) < 30) {
                    volvoWorkshop.load(volvo);
                }
            }
        }
    }

    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(brake);
        }
    }

    void startEngine() {
        for (Car car : cars) {
            car.startEngine();
        }
    }

    void stopEngine() {
        for (Car car : cars) {
            car.stopEngine();
        }
    }

    void turboOn() {
        for (Car car : cars) {
            if (car instanceof Saab95 saab) {
                saab.setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Car car : cars) {
            if (car instanceof Saab95 saab) {
                saab.setTurboOff();
            }
        }
    }

    void raiseBed() {
        for (Car car : cars) {
            if (car instanceof Scania scania) {
                scania.raiseBed(scania.maxBedAngle);
            }
        }
    }

    void lowerBed() {
        for (Car car : cars) {
            if (car instanceof Scania scania) {
                scania.lowerBed(scania.maxBedAngle);
            }
        }
    }
}
