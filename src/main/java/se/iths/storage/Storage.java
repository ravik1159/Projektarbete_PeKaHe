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

    public boolean arrayListHandler() throws Exception {
        File yourFile = new File("contactsaves.txt");
        yourFile.createNewFile(); // if file already exists, will do nothing
        if (isEmpty(yourFile)) {
            return false;
        } else {
            loadFromFile();
            return true;
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

    public boolean isEmpty(File checkFile) {
        if(checkFile.length() == 0) {
            System.out.println("File is empty");
            return true;
        } else {
            System.out.println("File is not empty");
            return false;
        }
    }

}
