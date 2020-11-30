package se.iths.main;

import se.iths.contactdomain.Contact;
import se.iths.contactdomain.ContactBook;
import se.iths.storage.Storage;
import se.iths.userinteraction.UserInteraction;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;

public class Main {

    private static UserInteraction userInteraction = new UserInteraction();
    private static Storage storage = new Storage();
    private static ContactBook contactBook = new ContactBook();

    public static void main(String[] args)  {


        try{
            userInteraction.startMenue();
        }
        catch (Exception e){
            e.printStackTrace();
        }


        //contactBook.saveOurContactBook();

/*
        ArrayList<Contact> testArraylist = new ArrayList<>();
        testArraylist.add(new Contact("Korv", "Lund", 708888000));
        testArraylist.add(new Contact("Tjosan", "Jox", 1111111111));

        storage.writeToFile(contactBook.saveOurContactBook());



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

        ArrayList<Contact> testArrayList2 = new ArrayList<>();
        try{
            FileInputStream fileInputStream = new FileInputStream("contactsaves.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            testArrayList2 = (ArrayList<Contact>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();

        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        for(int i = 0; i < testArrayList2.size(); i++){
            System.out.println("Name: " + testArrayList2.get(i).getFirstName() + " " + testArrayList2.get(i).getLastName()
                    + "\tTelephone number: " + testArrayList2.get(i).getTelephone());
        }


*/


    }
}
