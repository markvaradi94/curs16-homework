package ro.fasttrackit.mvnbase.homework.exercise1;

import org.decimal4j.util.DoubleRounder;

public class TemperatureConverter {

    public static double fahrenheitToCelsius(double temperature) {
        if (temperature < -459.67) {
            throw new IllegalArgumentException();
        }
        return DoubleRounder.round((temperature - 32) * (5d / 9d), 2);
    }

    public static double celsiusToFahrenheit(double temperature) {
        if (temperature < -273.15) {
            throw new IllegalArgumentException();
        }
        return DoubleRounder.round((temperature * (9d / 5d)) + 32, 2);
    }
}
