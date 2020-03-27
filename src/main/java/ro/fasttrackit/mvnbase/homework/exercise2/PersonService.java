package ro.fasttrackit.mvnbase.homework.exercise2;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonService {
    private List<Person> persons = new ArrayList<>();
    private Set<Integer> idNumbers = new HashSet<>();
    private static int idNumber = 1;

    public Person addPerson(Person person) {
        person = new Person(idNumber, person.getName(), person.getAge());
        idNumbers.add(idNumber);
        idNumber++;
        persons.add(person);
        return person;
    }

    public List<Person> getAllPersons() {
        return new ArrayList<>(this.persons);
    }

    private void verifyIdNumber(int id) {
        if (!idNumbers.contains(id)) {
            throw new IllegalArgumentException("Invalid ID number");
        }
    }

    public Person removePerson(int id) {
        verifyIdNumber(id);
        Person person = getPersonById(id);
        this.persons.remove(person);
        return person;
    }

    public Person getPersonById(int id) {
        verifyIdNumber(id);
        for (Person person : this.persons) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    public List<Person> getPersonsOlderThan(int age) {
        verifyAge(age);
        List<Person> result = new ArrayList<>();
        for (Person person : this.persons) {
            if (person.getAge() > age) {
                result.add(person);
            }
        }
        return result;
    }

    public List<String> getAllPersonNames() {
        List<String> result = new ArrayList<>();
        for (Person person : this.persons) {
            result.add(person.getName());
        }
        return result;
    }

    private void verifyAge(int age) {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Invalid age");
        }
    }

    private Person personByName(String name) {
        verifyName(name);
        for (Person person : this.persons) {
            if (person.getName().equalsIgnoreCase(name)) {
                return person;
            }
        }
        return null;
    }

    public Person getPerson(String name) {
        if (personByName(name) == null) {
            throw new IllegalArgumentException("Person not found");
        }
        return personByName(name);
    }

    private void verifyName(String name) {
        verifyNotNull(name);
        Pattern pattern = Pattern.compile("^[ A-za-z'\\-]+$");
        Matcher matcher = pattern.matcher(name);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid name");
        }
    }

    private <T> void verifyNotNull(T t) {
        if (t == null || t.equals("")) {
            throw new IllegalArgumentException("Invalid name");
        }
    }
}
