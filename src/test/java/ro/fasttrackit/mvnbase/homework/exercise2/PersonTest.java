package ro.fasttrackit.mvnbase.homework.exercise2;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    @DisplayName("WHEN age is less than 0 or more than 120 THEN exception is thrown")
    void invalidAge() {
        //SETUP
        //RUN + ASSERT
        assertThrows(IllegalArgumentException.class, () -> new Person("name", 150));
    }

    @Test
    @DisplayName("WHEN name is null THEN exception is thrown")
    void nullName() {
        //SETUP
        //RUN + ASSERT
        assertThrows(IllegalArgumentException.class, () -> new Person(0, null, 20));
    }

    @Test
    @DisplayName("WHEN name is an empty string THEN exception is thrown")
    void emptyName() {
        //SETUP
        //RUN + ASSERT
        assertThrows(IllegalArgumentException.class, () -> new Person("", 12));
    }

    @Test
    @DisplayName("WHEN name contains non-letters THEN exception is thrown")
    void nonLettersInName() {
        //SETUP
        //RUN + ASSERT
        assertThrows(IllegalArgumentException.class, () -> new Person("Maria123", 20));
    }
}
