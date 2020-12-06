package se.iths.storage;

import se.iths.contactdomain.Contact;
import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Storage {

    public void writeToFile(ArrayList<Contact> contactArrayList, String fileName) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(contactArrayList);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException ioe) {
            System.out.println("Unable to save to file");
            ioe.printStackTrace();
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
                throw new IOException("Unable to load from file");
            }
        catch (ClassNotFoundException cnfe) {
            throw new ClassNotFoundException("Unable to load from file");
        }
    }
}


