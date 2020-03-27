package ro.fasttrackit.mvnbase.homework.exercise1;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static ro.fasttrackit.mvnbase.homework.exercise1.TemperatureConverter.*;

public class TemperatureConverterTest {

    @Test
    @DisplayName("WHEN celsius temperature is received THEN correct fahrenheit is returned")
    void positiveTemperatureToFahrenheit() {
        //SETUP
        //RUN
        var result = celsiusToFahrenheit(21);
        //ASSERT
        assertThat(result).isEqualTo(69.8);
    }

    @Test
    @DisplayName("WHEN fahrenheit temperature is received THEN correct celsius is returned")
    void positiveTemperatureToCelsius() {
        //SETUP
        //RUN
        var result = fahrenheitToCelsius(50);
        //ASSERT
        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("WHEN celsius is below absolute zero THEN exception is thrown")
    void belowAbsoluteZeroToFahrenheit() {
        //SETUP
        //RUN + ASSERT
        assertThrows(IllegalArgumentException.class, () -> celsiusToFahrenheit(-273.16));
    }

    @Test
    @DisplayName("WHEN fahrenheit is below absolute zero THEN exception is thrown")
    void belowAbsoluteZeroToCelsius() {
        //SETUP
        // RUN + ASSERT
        assertThrows(IllegalArgumentException.class, () -> fahrenheitToCelsius(-459.68));
    }
}
