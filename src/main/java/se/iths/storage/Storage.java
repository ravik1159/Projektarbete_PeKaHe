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
            ioe.printStackTrace();
        }
    }
//Petra: moved this method to loadFromFile. Delete the block if OK or uncomment and restore code as it was
//    public boolean fileContainsContacts() throws Exception {
//        File yourFile = new File("contactsaves.txt");
//        yourFile.createNewFile(); // if file already exists, will do nothing
//        if (yourFile.length() == 0) {
//            // file does not contains contacts
//            return false;
//        } else {
//            // if txt file is not empty, it will load the txt file
//            return true;
//        }
//    }

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
            ioe.printStackTrace();
            return null;
        }
    }
}
