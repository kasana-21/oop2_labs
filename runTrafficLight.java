package observer;

public class runTrafficLight {
    public static void main(String[] args) {
        // Create a traffic light object
        TrafficLight trafficLight = new TrafficLight();

        // Create observer objects
        TrafficLightDisplay displayObserver = new TrafficLightDisplay();
        TrafficLightLogger loggerObserver = new TrafficLightLogger();

        // Add the observers to the traffic light
        trafficLight.addObserver(displayObserver);
        trafficLight.addObserver(loggerObserver);

        // Simulate changing the state of the traffic light
        trafficLight.setState("GREEN");
        trafficLight.setState("YELLOW");
        trafficLight.setState("RED");

        // Remove the logger observer
        trafficLight.removeObserver(loggerObserver);

        // Simulate changing the state of the traffic light again
        trafficLight.setState("GREEN");
        trafficLight.setState("YELLOW");
        trafficLight.setState("RED");
    }
}