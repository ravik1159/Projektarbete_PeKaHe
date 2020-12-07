package se.iths.storage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import se.iths.contactdomain.Contact;
import se.iths.contactdomain.ContactBook;

import java.io.*;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class StorageTest {

    private ArrayList<Contact> testContacts;
    private static Storage storage = new Storage();
    private static String goodFileName = "storagetestsaves.txt";
    private static String badFileName = "X:\\";

    //Prep for reassign the standard output stream to a new PrintStream with a ByteArrayOutputStream
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setup() {
        testContacts = new ArrayList<>(); //Needed to be able to add Contacts to arraylist using the standard add method instead of our own addContact method
        Contact cont1 = new Contact("Petra", "Andreasson", "077436436");
        testContacts.add(cont1);

        //we reassign the standard output stream to a new PrintStream with a ByteArrayOutputStream
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        File file = new File(goodFileName);
        file.delete();
        System.setOut(standardOut); //roll back re-assignment of standard output stream done in @BeforeEach
    }

    @Test
    void writeToFileSuccess() throws IOException {
        File file = new File(goodFileName);
        file.delete();
        assertFalse(file.exists());  //Double check that file is deleted before saving
            storage.writeToFile(testContacts, goodFileName);
        assertTrue(file.exists());
    }
    private void print(String output) {
        System.out.println(output);
    }

    @Test
    void writeToFileThrowsError() {
        assertThrows(IOException.class, () -> {
            storage.writeToFile(testContacts, badFileName);
        });

      //assertThrows(FileNotFoundException.class, () -> {
      //     storage.writeToFile(testContacts, badFileName);});
        //assertEquals("Unable to save to file", outputStreamCaptor.toString().trim());

    }

    @Test
    void testLoadFromFileCreatesNewFileIfNoneExist() throws IOException, ClassNotFoundException {
        File file = new File(goodFileName);
        file.delete();
        assertFalse(file.exists());
        storage.loadFromFile(goodFileName);
        assertTrue(file.exists());
    }
    @Test
    void testLoadFromFileReturnsNewArrayListIfFileWasEmpty() throws IOException, ClassNotFoundException {
        ArrayList<Contact> testLoadOurContactBook = storage.loadFromFile(goodFileName);
        assertEquals(0, testLoadOurContactBook.size());
    }

    @Test
    void testLoadFromFileLoadsArrayListWhenFileExists() throws IOException, ClassNotFoundException {
            //Create a file that contains one object in ArrayList
            FileOutputStream fileOutputStream = new FileOutputStream(goodFileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(testContacts);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();

        ArrayList<Contact> testLoadOurContactBook = storage.loadFromFile(goodFileName);

        ContactBook addedContacts = new ContactBook(testLoadOurContactBook, goodFileName);
        assertEquals(1, addedContacts.getOurContactBook().size());

        Contact contact = testLoadOurContactBook.get(0);
        assertEquals("Petra", contact.getFirstName());
        assertEquals("Andreasson", contact.getLastName());
        assertEquals("077436436", contact.getTelephone());
    }

    @Test
    void testLoadFromFileThrowsIoException() {

       assertThrows(IOException.class, () -> {
           storage.loadFromFile(badFileName);
           });
    }
    @Test
    void testLoadFromFileThrowsClassNotFoundException()  {
    }
}