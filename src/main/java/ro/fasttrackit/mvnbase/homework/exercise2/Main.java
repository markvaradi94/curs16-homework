package ro.fasttrackit.mvnbase.homework.exercise2;

public class Main {
    public static void main(String[] args) {
        PersonService service = new PersonService();
        service.addPerson(new Person("Maria", 25));
        service.addPerson(new Person("Tom", 37));
        service.addPerson(new Person("Mike", 29));
        service.addPerson(new Person("Tim", 69));
        System.out.println(service.getAllPersons());
        printSeparator();
        System.out.println(service.removePerson(2));
        printSeparator();
        System.out.println(service.getAllPersons());
        service.addPerson(new Person("Ash", 42));
        printSeparator();
        System.out.println(service.getAllPersons());
        printSeparator();
        System.out.println(service.getPersonsOlderThan(40));
        printSeparator();
        System.out.println(service.getAllPersonNames());
        printSeparator();
        System.out.println(service.getPerson("ash"));
        printSeparator();
        System.out.println(service.getPersonById(4));
        printSeparator();
        System.out.println(service.getPersonById(3));
        printSeparator();
        service.getPersonById(200);
    }

    public static void printSeparator() {
        System.out.println("=========================================================================================");
    }
}
