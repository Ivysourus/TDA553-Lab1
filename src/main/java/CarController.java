import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    ArrayList<EngineVehicle> cars = new ArrayList<>();

    public static void main(String[] args) {
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        cc.cars.add(new Scania());
        cc.cars.add(new Saab95());

        cc.frame = new CarView("CarSim 1.0", cc);

        cc.timer.start();
    }

    /*
     * Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (EngineVehicle car : cars) {
                car.move();
                int x = (int) Math.round(car.getPos().x);
                int y = (int) Math.round(car.getPos().y);
                frame.drawPanel.moveit(x, y);
                frame.drawPanel.repaint();
            }
        }
    }

    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (EngineVehicle car : cars) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (EngineVehicle car : cars) {
            car.brake(brake);
        }
    }

    void startEngine() {
        for (EngineVehicle car : cars) {
            car.startEngine();
        }
    }

    void stopEngine() {
        for (EngineVehicle car : cars) {
            car.stopEngine();
        }
    }

    void turboOn() {
        for (EngineVehicle car : cars) {
            if (car instanceof Saab95 saab) {
                saab.setTurboOn();
            }
        }
    }

    void turboOff() {
        for (EngineVehicle car : cars) {
            if (car instanceof Saab95 saab) {
                saab.setTurboOff();
            }
        }
    }

    void raiseBed() {
        for (EngineVehicle car : cars) {
            if (car instanceof Scania scania) {
                scania.raiseBed(scania.maxBedAngle);
            }
        }
    }

    void lowerBed() {
        for (EngineVehicle car : cars) {
            if (car instanceof Scania scania) {
                scania.lowerBed(scania.maxBedAngle);
            }
        }
    }
}
