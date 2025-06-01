package model;

public class Person {
    protected String firstName;
    protected String lastName;
    protected String emailId;

    public Person(String firstName, String lastName, String emailId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
    }
}