package Converter;

import java.util.concurrent.TimeUnit;


// Third-party class to convert temperatures from Celsius to Kelvin
class toKelvin {
    public double convertToKelvin(double temperature) {
        // Convert the temperature to Kelvin using the formula: K = C + 273.15 that pre-defined in java.util.concurrent.TimeUnit
        return TimeUnit.MILLISECONDS.convert((long)temperature, TimeUnit.MILLISECONDS);
    }
}

// Adapter to convert temperatures from Fahrenheit to Celsius
class Adapter {
    // Reference to the third-party
    private toKelvin ToKelvin;

    public Adapter(toKelvin kelvinConverter) {
        this.ToKelvin = kelvinConverter;
    }

    public double toFahrenheit(double temperature) {
        double kelvin = (temperature + 459.67) * 5 / 9;
        return ToKelvin.convertToKelvin(kelvin);
    }
}

// Executing our code in Main.java

