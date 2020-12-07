package se.iths.storage;

import se.iths.contactdomain.Contact;
import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Storage {

    public void writeToFile(ArrayList<Contact> contactArrayList, String fileName) throws IOException{
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(contactArrayList);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException ioe) {
            throw new IOException("\nWarning! Unable to save your contactbook.");
        }
    }

    public ArrayList<Contact> loadFromFile(String fileName) throws IOException, ClassNotFoundException {
        ArrayList<Contact> loadOurContactBook;
        try {
            File yourFile = new File(fileName);
            yourFile.createNewFile(); // if file already exists, will do nothing
            if (yourFile.length() == 0) {
                // file does not contains contacts
                loadOurContactBook = new ArrayList<>();
            } else {
                FileInputStream fileInputStream = new FileInputStream(yourFile);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                loadOurContactBook = (ArrayList<Contact>) objectInputStream.readObject();
                objectInputStream.close();
                fileInputStream.close();
            }
            return loadOurContactBook;
        }
        catch (IOException ioe) {
                throw new IOException("\nWarning! Unable to load your contactbook. Filename should be contactsaves.txt. " +
                        "This is the current filename: " + fileName + "\nPlease contact Petra, Karen or Helena");
            }
        catch (ClassNotFoundException cnfe) {
                throw new ClassNotFoundException("\nWarning! Unable to load from file. Unknown error.");
        }
    }
}


