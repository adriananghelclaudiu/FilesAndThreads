package ro.ctrln.model;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {
    private String firstName;
    private String lastName;
    private int age;
    private String job;

    public Person() {}

    public Person(String firstName, String lastName, int age, String job) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.job = job;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                firstName.equals(person.firstName) &&
                lastName.equals(person.lastName) &&
                job.equals(person.job);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, job);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }
}
