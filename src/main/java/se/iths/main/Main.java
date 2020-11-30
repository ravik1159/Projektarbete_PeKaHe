package se.iths.main;


import se.iths.userinteraction.UserInteraction;


public class Main {

    private static UserInteraction userInteraction = new UserInteraction();

    public static void main(String[] args) throws Exception  {


        userInteraction.startMenue();



        //userInteraction.startMenue();
        //contactBook.saveOurContactBook();
/*
        ArrayList<Contact> testArraylist = new ArrayList<>();
        testArraylist.add(new Contact("Tjosan", "Jox", "1111111111"));
        testArraylist.add(new Contact("Karen", "JHej", "111155511"));


        try{
            FileOutputStream fileOutputStream = new FileOutputStream("contactsaves.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(testArraylist);
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
