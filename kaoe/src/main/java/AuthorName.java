package main.java;

public class AuthorName {

    String firstNames;
    String lastName;

    public AuthorName(String firstName, String lastName){
        this.firstNames = firstName;
        this.lastName = lastName;
    }

    public String getFirstNames() {
        return firstNames;
    }

    public void setFirstNames(String firstNames) {
        this.firstNames = firstNames;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
