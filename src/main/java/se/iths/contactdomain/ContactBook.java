package se.iths.contactdomain;

import se.iths.storage.Storage;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class ContactBook {

    private static Storage storage = new Storage();
    private ArrayList<Contact> ourContactBook;

    public ContactBook() {
        //this.ourContactBook = new ArrayList<>();
    }

    public void loadOurContactBook() throws Exception{
        ourContactBook = storage.loadFromFile();
    }

    public void saveOurContactBook() throws Exception{
        storage.writeToFile(ourContactBook);
    }

    public void addContact(Contact newContact) {
        if(searchContact(newContact.getFirstName()) != null) {
            System.out.println(newContact.getFirstName() + " is already in your contactbook.");
        } else {
            ourContactBook.add(newContact);
            System.out.println(newContact.getFirstName() + " has now been added to your contactbook.");
        }
    }

    // Kollar bara om samma FirstName finns (kollar inte på kombination med lastName eller phoneNumber)
    private int findContact(String contactFirstName) {

        for (int i = 0; i < ourContactBook.size(); i++) {
            Contact contact = this.ourContactBook.get(i);
            if (contact.getFirstName().equals(contactFirstName)) {
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
    public Contact searchContact(String firstName){

        int index = findContact(firstName);

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

}
