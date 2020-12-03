package se.iths.storage;

import se.iths.contactdomain.Contact;
import java.io.*;
import java.util.ArrayList;

public class Storage {

    public void writeToFile(ArrayList<Contact> contactArrayList)  {
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("contactsaves.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(contactArrayList);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
        }
        catch (IOException ioe){
            System.out.println("Unable to save to file");
            ioe.printStackTrace();
        }
    }

    public ArrayList<Contact> loadFromFile() {
        ArrayList<Contact> loadOurContactBook;
        try{
            File yourFile = new File("contactsaves.txt");
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
        } catch (IOException | ClassNotFoundException ioe){
            System.out.println("Unable to load from file");
            ioe.printStackTrace();
            return null;
        }
    }
}
