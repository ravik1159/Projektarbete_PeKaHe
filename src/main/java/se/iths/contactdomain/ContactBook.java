package se.iths.contactdomain;

import se.iths.storage.Storage;
import java.util.ArrayList;

public class ContactBook {
    private static Storage storage = new Storage();
    private ArrayList<Contact> ourContactBook;
    private String fileName;


    public ContactBook(String fileName) {
        this.fileName = fileName;
        this.ourContactBook = storage.loadFromFile(fileName);
    }

    public ContactBook(ArrayList<Contact> listOfContacts) {
        this.ourContactBook = listOfContacts;
    }

    public ArrayList<Contact> getListOfContacts() {
        return ourContactBook;
    }

    public void saveOurContactBook() {
          storage.writeToFile(ourContactBook, fileName);
    }

    public boolean addContact(Contact newContact) {
        if(findContact(newContact.getFirstName(), newContact.getLastName()) >= 0) {
            System.out.println(newContact.getFirstName() + " is already in your contact book.");
            return false;
        } else {
            if(ourContactBook.add(newContact)) {
                saveOurContactBook();
                return true;
            } else {
                System.out.println("Something went wrong, contact could not be added to your contact book");
                return false;
            }
        }
    }

    // Kontrollerar För- och Efternamn mot ourContactBook
    private int findContact(String contactFirstName, String contactLastName) {

        for(Contact contact: ourContactBook){
            if(contact.getFirstName().toLowerCase().trim().equals(contactFirstName.toLowerCase().trim()) &&
                    contact.getLastName().toLowerCase().trim().equals(contactLastName.toLowerCase().trim())){
                return ourContactBook.indexOf(contact);
            }
        }
        return -1;
    }

    public Contact searchContact(String firstName, String lastName){
        int index = findContact(firstName, lastName);
        if(index >= 0){
            return this.ourContactBook.get(index);
        }
        return null;
    }

    public void printContactBook(){
        if(ourContactBook.size() > 0) {
            System.out.println("Our contacts:");
            for (Contact contact : this.ourContactBook) {
                System.out.println("Name: " + contact.getFirstName() + " " + contact.getLastName());
                System.out.println("Telephone number: " + contact.getTelephone());
            }
        } else {
            System.out.println("Contact book is empty");
        }
    }

    public boolean removeContact(String firstName, String lastName) {
        int contactIndex = findContact(firstName, lastName);
        if(contactIndex >=0) {
            if (ourContactBook.remove(contactIndex) == null) {
                //"Contact couldn't be removed from contact book"
                return false;
            } else {
                saveOurContactBook();
                //"Contact removed from contact book"
                return true;
            }
        } else {
            //index <0 i.e. "Name not found in contact book"
            return false;
        }
    }

    public ArrayList<Contact> getOurContactBook() {
        return ourContactBook;
    }
}
