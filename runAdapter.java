package Converter;

public class runAdapter {
    public static void main(String[] args) {
        // Create an instance of the third-party
        Converter.toKelvin kelvinConverter = new Converter.toKelvin();

        // Create an instance of the FahrenheitToCelsiusAdapter, passing the KelvinConverter
        Converter.Adapter adapter = new Converter.Adapter(kelvinConverter);

        // Convert celsius temperature to fahrenheit
        double fahrenheitTemperature = 75.5;
        double celsiusTemperature = adapter.toFahrenheit(fahrenheitTemperature);

        // Display the converted temperatures
        System.out.println("Fahrenheit temperature: " + fahrenheitTemperature);
        System.out.println("Celsius temperature: " + celsiusTemperature);
    }
}
