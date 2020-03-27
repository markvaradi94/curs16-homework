package ro.fasttrackit.mvnbase.homework.exercise2;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
public class PersonServiceTest {
    private PersonService service;

    @BeforeAll
    void setup() {
        service = new PersonService();
        service.addPerson(new Person("Maria", 25));
        service.addPerson(new Person("Tom", 37));
        service.addPerson(new Person("Mike", 29));
        service.addPerson(new Person("Tim", 69));
    }

    @Test
    @DisplayName("WHEN searching for invalid ID THEN exception is thrown")
    void invalidIdIntroduced() {
        //SETUP
        //RUN + ASSERT
        assertThrows(IllegalArgumentException.class, () -> service.getPersonById(0));
    }

    @Test
    @DisplayName("WHEN removing person with invalid ID THEN exception is thrown")
    void removeWithInvalidId() {
        //SETUP
        //RUN + ASSERT
        assertThrows(IllegalArgumentException.class, () -> service.removePerson(15));
    }

    @Test
    @DisplayName("WHEN looking for an invalid age THEN exception is thrown")
    void invalidAge() {
        //SET
        //RUN + ASSERT
        assertThrows(IllegalArgumentException.class, () -> service.getPersonsOlderThan(150));
    }

    @Test
    @DisplayName("WHEN looking for an invalid name THEN exception is thrown")
    void invalidName() {
        //SET
        //RUN + ASSERT
        assertThrows(IllegalArgumentException.class, () -> service.getPerson("mara"));
    }
}
