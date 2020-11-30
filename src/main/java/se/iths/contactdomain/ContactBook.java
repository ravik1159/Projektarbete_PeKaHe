package se.iths.contactdomain;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class ContactBook {

    private ArrayList<Contact> ourContactBook;

    public ContactBook() {
        this.ourContactBook = new ArrayList<>();
    }

    public void addContact(Contact newContact) {
        if(findContact(newContact.getFirstName(), newContact.getLastName()) >= 0) {
            System.out.println(newContact.getFirstName() + " is already in your contactbook.");
        } else {
            ourContactBook.add(newContact);
            System.out.println(newContact.getFirstName() + " has now been added to your contactbook.");
        }
    }

    // Kontrollerar För- och Efternamn mot ourContactBook
    private int findContact(String contactFirstName, String contactLastName) {

        for (int i = 0; i < ourContactBook.size(); i++) {
            Contact contact = this.ourContactBook.get(i);
            if (contact.getFirstName().toLowerCase().trim().equals(contactFirstName.toLowerCase().trim()) &&
                    contact.getLastName().toLowerCase().trim().equals(contactLastName.toLowerCase().trim())) {
                return i;
            }
        }
        return -1;
         /* Enhanced for-loop som jag vill testa sen när det finns sakern man kan testa med ;)

        for(Contact contact: ourContactBook){
            if(contact.getFirstName().equals(contactFirstName)){
                return ourContactBook.indexOf(contact);
            }
        }
        return -1;

         */
    }
    //@Override ??
    public Contact searchContact(String firstName, String lastName){

        int index = findContact(firstName, lastName);

        if(index >= 0){
            return this.ourContactBook.get(index);
        }
        return null;
    }

    public void printContactBook(){
        System.out.println("Our contacts:");

        for(int i = 0; i < this.ourContactBook.size(); i++){
            System.out.println("Name: " + this.ourContactBook.get(i).getFirstName() + " " + this.ourContactBook.get(i).getLastName());
            System.out.println("Telephone number: " + this.ourContactBook.get(i).getTelephone());
        }
    }

    public boolean removeContact(String firstName, String lastName) {
        int contactIndex = findContact(firstName, lastName);
        if(contactIndex >=0) {
            if (ourContactBook.remove(contactIndex) == null) {
                System.out.println("Contact couldn't be removed from contact book");
                return false;
            } else {
                System.out.println("Contact removed from contact book");
                return true;
            }
        } else {
            System.out.println("Title not found in eBook list");
            return false;
        }
    }
}
