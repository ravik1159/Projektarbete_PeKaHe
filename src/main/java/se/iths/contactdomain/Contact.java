package se.iths.contactdomain;

public class Contact {

    private String firstName;
    private String lastName;
    private int telephone;

    public Contact(String firstName, String lastName, int telephone) {
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

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
}
