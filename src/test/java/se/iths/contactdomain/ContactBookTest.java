package se.iths.contactdomain;

import org.junit.jupiter.api.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContactBookTest {

    private static String testStorageFile = "testsaves.txt";
    private static ContactBook addedContacts;

    @BeforeEach
    void setup() {
        ArrayList<Contact> testContacts = new ArrayList<>(); //Needed to be able to add Contacts to arraylist using the standard add method instead of our own addContact method
        Contact cont1 = new Contact("Petra", "Andreasson", "077436436");
        Contact cont2 = new Contact("Helena", "Lundström", "943743587");
        Contact cont3 = new Contact("Karen", "Batjes", "73428465");
        testContacts.add(cont1);
        testContacts.add(cont2);
        testContacts.add(cont3);
        addedContacts = new ContactBook(testContacts, testStorageFile);
    }

    @AfterEach
    void tearDown() {
        File file = new File(testStorageFile);
        file.delete();
    }

    @Test
    void saveOurContactBook() {
        File file = new File(testStorageFile);
        file.delete();
        assertFalse(file.exists());  //Double check that file is deleted before saving
        addedContacts.saveOurContactBook();
        assertTrue(file.exists());
    }

    @Test
    void addContact() {
        Contact cont1 = new Contact("Petra", "Andreasson", "077436436");
        Contact cont2 = new Contact("Kalle", "Anka", "943743587");
        Contact cont3 = new Contact("KALLE", "anka", "73428465");

        assertFalse(addedContacts.addContact(cont1));
        assertTrue(addedContacts.addContact(cont2));
        assertFalse(addedContacts.addContact(cont3));

        assertEquals(4, addedContacts.getOurContactBook().size());
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
        assertEquals(2, addedContacts.getOurContactBook().size());
    }

    // Vi har valt att inte testa metoden findContact() i ContactBook i och med att det är en privat metod.
    //Metoden testas indirekt genom testAddContact, testSearchContact och testRemoveContact.
    @Disabled
    void testFindContact(){
    }
}