package se.iths.storage;

import se.iths.contactdomain.Contact;
import se.iths.contactdomain.ContactBook;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;

public class Storage {

    public void writeToFile(ArrayList contactArrayList) {

        try{
            FileOutputStream fileOutputStream = new FileOutputStream("contactsaves.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(contactArrayList);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public boolean fileContainsContacts()  {
        try {
            File yourFile = new File("contactsaves.txt");
            yourFile.createNewFile(); // if file already exists, will do nothing
            if (yourFile.length() == 0) {
                // file does not contains contacts
                return false;
            } else {
                // if txt file is not empty, it will load the txt file
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    public ArrayList<Contact> loadFromFile() {

        ArrayList<Contact> loadOurContactBook;
        try{
            FileInputStream fileInputStream = new FileInputStream("contactsaves.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            loadOurContactBook = (ArrayList<Contact>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            return loadOurContactBook;

        } catch (IOException | ClassNotFoundException exc){
            exc.printStackTrace();
            return null;
        }

    }

}
