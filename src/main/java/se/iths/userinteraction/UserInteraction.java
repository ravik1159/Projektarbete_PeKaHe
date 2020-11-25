package se.iths.userinteraction;

import java.util.Scanner;

public class UserInteraction {
    private static Scanner scan = new Scanner(System.in);

    public void startMenue(){

        boolean quit = false;

        showMenue();

        while(!quit){
            int action = scan.nextInt();
            scan.nextLine();
            if (action == 0){
                System.out.println("\n Shutting down..");
                quit = true;
            } else{
                choiceSwitch(action);
            }
        }
    }

    public void showMenue(){
        System.out.println("Menue");
        System.out.println("0 - to shutdown");
        System.out.println("1 - Print contacts");
        System.out.println("2 - Add new contact");
        System.out.println("3 - Remove existing contact");
        System.out.println("4 - Query contact exists");
        System.out.println("5 - Print menue");
        System.out.print("Choose your action:");
    }

    public void choiceSwitch(int action) {
        switch (action) {
                /*
            case 1:
                .printContacts();
                break;
            case 2:
                addNewContact();
                break;
            case 3:
                removeContact();
                break;
            case 4:
                queryContact();
                break;
                */
            case 5:
                showMenue();
                break;

        }
    }
}
