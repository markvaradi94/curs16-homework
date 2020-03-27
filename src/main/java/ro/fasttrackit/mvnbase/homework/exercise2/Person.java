package ro.fasttrackit.mvnbase.homework.exercise2;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {
    private int id;
    private final String name;
    private final int age;

    public Person(int id, String name, int age) {
        this.id = id;
        verifyName(name);
        this.name = name;
        verifyAge(age);
        this.age = age;
    }

    public Person(String name, int age) {
        this(-1, name, age);
    }

    public Person() {
        this(-1, "unknown", 25);
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

    private void verifyAge(int age) {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Invalid age");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id = " + id +
                ", name = " + name +
                ", age = " + age +
                '}';
    }
}
