package se.iths.contactdomain;

import java.util.ArrayList;

public class ContactBook {

    private ArrayList<Contact> ourContactBook;

    public ContactBook() {
        this.ourContactBook = new ArrayList<>();
    }

    public void addContact(Contact newContact) {
    }

    private int findContact(String contactFirstName) {

        for (int i = 0; i < ourContactBook.size(); i++) {
            Contact contact = this.ourContactBook.get(i);
            if (contact.getFirstName().equals(contactFirstName)) {
                return i;
            }
        }
        return -1;
         /* Enhanced for-loop som jag vill testa sen när det finns sakern man kan testa med ;)

        for(Contact index: ourContactBook){
            Contact contact = index;
            if(contact.getFirstName().equals(contactFirstName)){
                return ourContactBook.indexOf(contact);
            }
        }
        return -1;

         */
    }

}
