package se.iths.contactdomain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContactBookTest {

    private static ContactBook addedContacts;
//    private static Contact cont1;
//    private static Contact cont2;
//    private static Contact cont3;

    @BeforeAll
    static void setup() {
        List<Contact> testContacts = new ArrayList<>(); //Needed to be able to add Contacts to arraylist using the standard add method instead of our own addContact method
        Contact cont1 = new Contact("Petra", "Andreasson", "077436436");
        Contact cont2 = new Contact("Helena", "Lundström", "943743587");
        Contact cont3 = new Contact("Karen", "Batjes", "73428465");
        testContacts.add(cont1);
        testContacts.add(cont2);
        testContacts.add(cont3);
        addedContacts = (ContactBook) testContacts;
    }

    @BeforeEach
    void setUp() {
    }

    @Test
    void saveOurContactBook() {
    }

    @Test
    void addContact() {
    }

    @Test
    void searchContact() {
    }

    @Test
    void printContactBook() {
    }

    @Test
    void removeContact() {
        assertTrue(addedContacts.removeContact("Petra", "Andreasson"));
        assertFalse(addedContacts.removeContact("Kurt","j342k!#"));
        //assertEquals(2, );//expect, actual Vill testa arraylistans längd
    }
}