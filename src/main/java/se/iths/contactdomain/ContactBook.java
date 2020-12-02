package se.iths.contactdomain;

import se.iths.storage.Storage;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class ContactBook {

    private static Storage storage = new Storage();
    private ArrayList<Contact> ourContactBook;

    public void loadOurContactBook() throws Exception{
        if(storage.fileContainsContacts()) {
            // once we know the file contains contacts, we will load info from it
            ourContactBook = storage.loadFromFile();
        } else {
            this.ourContactBook = new ArrayList<>();
        }
    }

    public void saveOurContactBook() throws Exception{
        storage.writeToFile(ourContactBook);
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
                try {
                    storage.writeToFile(ourContactBook);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Updated contactbook couldn't be saved to file");
                }
                //"Contact removed from contact book"
                return true;
            }
        } else {
            //index <0 i.e. "Name not found in contact book"
            return false;
        }
    }
}
