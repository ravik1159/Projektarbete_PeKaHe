package se.iths.contactdomain;

public class Contact {

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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
