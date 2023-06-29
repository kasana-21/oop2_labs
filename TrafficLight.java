
package observer;

import java.util.ArrayList;
import java.util.List;

// Subject (Observable) interface
interface TrafficLightSubject {
    void addObserver(TrafficLightObserver observer);

    void removeObserver(TrafficLightObserver observer);

    void notifyObservers();
}

// Concrete Subject class
class TrafficLight implements TrafficLightSubject {
    private String currentState;
    private List<TrafficLightObserver> observers;

    public TrafficLight() {
        this.currentState = "RED";
        this.observers = new ArrayList<>();
    }

    public void setState(String state) {
        this.currentState = state;
        notifyObservers();
    }

    public String getState() {
        return currentState;
    }

    @Override
    public void addObserver(TrafficLightObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(TrafficLightObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (TrafficLightObserver observer : observers) {
            observer.update(currentState);
        }
    }
}

// Observer interface
interface TrafficLightObserver {
    void update(String state);
}

// Concrete Observer classes
class TrafficLightDisplay implements TrafficLightObserver {
    @Override
    public void update(String state) {
        System.out.println("Traffic Light Display: The current state is " + state);
    }
}

class TrafficLightLogger implements TrafficLightObserver {
    @Override
    public void update(String state) {
        System.out.println("Traffic Light Logger: The current state is " + state);
    }
}


