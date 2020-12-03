package se.iths.contactdomain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContactBookTest {

    private static ContactBook contactBook = new ContactBook("testsaves.txt");
   // private static ContactBook addedContacts;
    //private static Contact cont1;
    //private static Contact cont2;
    //private static Contact cont3;

    @BeforeAll
    static void setup() {
        //ArrayList<Contact> testContacts = new ArrayList<>(); //Needed to be able to add Contacts to arraylist using the standard add method instead of our own addContact method
        //Contact cont1 = new Contact("Petra", "Andreasson", "077436436");
        //Contact cont2 = new Contact("Helena", "Lundström", "943743587");
        //Contact cont3 = new Contact("Karen", "Batjes", "73428465");

       // testContacts.add(cont1);
        //testContacts.add(cont2);
        //testContacts.add(cont3);
       //addedContacts = (ArrayList<Contact>) testContact;
    }

    @Test
    void saveOurContactBook() {
        fail("Not implemented");
    }

    @Test
    void addContact() {
        Contact cont1 = new Contact("Petra", "Andreasson", "077436436");
        Contact cont2 = new Contact("Helena", "Lundström", "943743587");
        Contact cont3 = new Contact("Karen", "Batjes", "73428465");

        contactBook.addContact(cont1);
        contactBook.addContact(cont2);
        contactBook.addContact(cont3);

        List<Contact> foundContacts = contactBook.getOurContactBook();

        assertEquals(3, foundContacts.size());
    }

    @Test
    void searchContact() {
        fail("Not implemented");
       //assertEquals(0, contactBook.searchContact("Petra", "Andreasson"));
    }

    @Test
    void printContactBook() {
        fail("Not implemented");
    }

    @Test
    void removeContact() {
        fail("Not implemented");
        //assertTrue(addedContacts.removeContact("Petra", "Andreasson"));
        //assertFalse(addedContacts.removeContact("Kurt","j342k!#"));
        //assertEquals(2, );//expect, actual Vill testa arraylistans längd
    }
}