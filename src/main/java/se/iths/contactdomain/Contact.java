package se.iths.contactdomain;

import java.io.Serializable;

public class Contact implements Serializable {

    private String firstName;
    private String lastName;
    private String telephone;

    public Contact(String firstName, String lastName, String telephone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTelephone() {
        return telephone;
    }

}
