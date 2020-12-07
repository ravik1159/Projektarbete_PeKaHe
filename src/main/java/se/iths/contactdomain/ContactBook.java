package se.iths.contactdomain;

import se.iths.storage.Storage;
import java.io.IOException;
import java.util.ArrayList;

public class ContactBook {
    private static Storage storage = new Storage();
    private ArrayList<Contact> ourContactBook;
    private String fileName;

    public ContactBook(String fileName) {
        this.fileName = fileName;
        try {
            this.ourContactBook = storage.loadFromFile(fileName);
        } catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    public ContactBook(ArrayList<Contact> listOfContacts, String fileName) {
        this.fileName = fileName;
        this.ourContactBook = listOfContacts;
    }

    public ArrayList<Contact> getOurContactBook() {
        return ourContactBook;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void saveOurContactBook () throws IOException {
            storage.writeToFile(ourContactBook, fileName);
        }

    public boolean addContact(Contact newContact) {
        if(findContact(newContact.getFirstName(), newContact.getLastName()) >= 0) {
            System.out.println(newContact.getFirstName() + " is already in your contact book.");
            return false;
        } else {
            if(ourContactBook.add(newContact)) {
                try{
                    saveOurContactBook();
                    return true;
                } catch(IOException ioe){
                    ioe.getMessage();
                    System.out.println("Please contact Petra, Karen or Helena in case of emergency");
                    return false;
                }
            } else {
                System.out.println("Something went wrong, contact could not be added to your contact book");
                return false;
            }
        }
    }

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
                try{
                    saveOurContactBook();
                    //"Contact removed from contact book"
                    return true;
                } catch(IOException ioe){
                    ioe.getMessage();
                    System.out.println("Please contact Petra, Karen or Helena in case of emergency");
                    return false;
                }
            }
        } else {
            System.out.println("Name not found in contact book");
            return false;
        }
    }
}
