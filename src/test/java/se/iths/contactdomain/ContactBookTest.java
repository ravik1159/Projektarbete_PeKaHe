package se.iths.contactdomain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContactBookTest {

    private static ContactBook baseContactBook;
    private static ContactBook addedContacts = new ContactBook("testsaves.txt");
    // private static ContactBook addedContacts;
    //private static Contact cont1;
    //private static Contact cont2;
    //private static Contact cont3;

//    @BeforeEach
//    static void setup() {
//        ArrayList<Contact> testContacts = new ArrayList<>(); //Needed to be able to add Contacts to arraylist using the standard add method instead of our own addContact method
//        Contact cont1 = new Contact("Petra", "Andreasson", "077436436");
//        Contact cont2 = new Contact("Helena", "Lundström", "943743587");
//        Contact cont3 = new Contact("Karen", "Batjes", "73428465");
//        testContacts.add(cont1);
//        testContacts.add(cont2);
//        testContacts.add(cont3);
//        addedContacts = new ContactBook(testContacts);
//    }

    @Test
    void setUp() {
        // skapar en självständig ArrayList som tar emot Contact objekt.
        ArrayList<Contact> testContacts = new ArrayList<>(); //Needed to be able to add Contacts to arraylist using the standard add method instead of our own addContact method

        // Skapar 3 test kontakter
        Contact cont1 = new Contact("Petra", "Andreasson", "077436436");
        Contact cont2 = new Contact("Helena", "Lundström", "943743587");
        Contact cont3 = new Contact("Karen", "Batjes", "73428465");

        // Lägger till 3 test kontakter till ArrayListan
        testContacts.add(cont1);
        testContacts.add(cont2);
        testContacts.add(cont3);

        // Constructor contactBook tar emot en filnamn och en arraylist (vilket blir den arraylistan vi precis har skapat)
        baseContactBook = new ContactBook(testContacts, "testsaves.txt");

        baseContactBook.printContactBook();
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

        baseContactBook.addContact(cont1);
        baseContactBook.addContact(cont2);
        baseContactBook.addContact(cont3);

        List<Contact> foundContacts = baseContactBook.getOurContactBook();

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
        assertTrue(addedContacts.removeContact("Petra", "Andreasson"));
        assertFalse(addedContacts.removeContact("Kurt","j342k!#"));
        assertEquals(2, addedContacts.getListOfContacts().size());
    }
}