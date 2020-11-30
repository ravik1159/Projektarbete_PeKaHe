package se.iths.storage;

import se.iths.contactdomain.Contact;
import se.iths.contactdomain.ContactBook;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;

public class Storage {

    public void writeToFile(ArrayList contactArrayList) throws Exception {

        try{
            FileOutputStream fileOutputStream = new FileOutputStream("contactsaves.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(contactArrayList);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
        }
        catch (IIOException ioe){
            ioe.printStackTrace();
        }
    }

    public ArrayList<Contact> loadFromFile() throws Exception{

        ArrayList<Contact> loadOurContactBook;
        try{

            FileInputStream fileInputStream = new FileInputStream("contactsaves.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            loadOurContactBook = (ArrayList<Contact>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            return loadOurContactBook;

        } catch (IOException ioe){
            ioe.printStackTrace();
            return null;
        }

    }

}
