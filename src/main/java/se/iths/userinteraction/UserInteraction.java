package se.iths.userinteraction;

import se.iths.contactdomain.Contact;
import se.iths.contactdomain.ContactBook;
import java.util.Scanner;

public class UserInteraction {
    private static Scanner scan = new Scanner(System.in);
    private static ContactBook contactBook = new ContactBook("X:\\");

    public void startMenu() {
        Scanner scan = new Scanner(System.in);
        boolean quit = false;

        System.out.println("\nMenu:\n---------------");
        showMenu();

        while(!quit){
            System.out.print("\nMake a choice (5 to show menu again): ");
            String input = scan.nextLine();
                while(input.isEmpty() || !(input.matches("[0-5]"))) {
                System.out.print("You must make a choice between 0 and 5 (5 to show list again): ");
                input = scan.nextLine();
                }

            int action = Integer.parseInt(input);
            if (action == 0){
                contactBook.saveOurContactBook();
                System.out.println("\nShutting down..");
                quit = true;
            } else{
                choiceSwitch(action);
            }
        }
   }

    private void showMenu(){
        System.out.println("0 - to shutdown");
        System.out.println("1 - Print contacts");
        System.out.println("2 - Add new contact");
        System.out.println("3 - Remove existing contact");
        System.out.println("4 - Search contact");
        System.out.println("5 - Print menu");
    }

    private void choiceSwitch(int action) {
        switch (action) {

            case 1:
                contactBook.printContactBook();
                break;
            case 2:
                addNewContact();
                break;
            case 3:
                removeContact();
                break;
            case 4:
                searchContact();
                break;
            case 5:
                showMenu();
                break;
        }
    }

    public void addNewContact() {
        String firstName, lastName;
        System.out.println("You are adding a new contact.");
        do {
            System.out.print("First name: ");
            firstName = scan.nextLine();
        } while(firstName.trim().isEmpty() || !firstName.matches("[\\w\\h-.]*"));
        do {
            System.out.print("Last name: ");
            lastName = scan.nextLine();
        } while(lastName.trim().isEmpty() || !lastName.matches("[\\w\\h-.]*"));
        System.out.print("Telephone number: ");
        String phoneNumber = scan.nextLine();
        while(phoneNumber.trim().isEmpty() || (!phoneNumber.matches("[\\d\\h-+]*"))) {
            System.out.println("Please enter a valid phone number:    (do not use letters)");
            phoneNumber = scan.nextLine();
        }
        Contact newContact = new Contact(firstName, lastName, phoneNumber);
        if(contactBook.addContact(newContact)) {
            System.out.println(newContact.getFirstName() + " has now been added and saved to your contact book.");
        }
    }

    public void searchContact(){
        System.out.println("Searching for a contact.");
        System.out.print("Enter firstname:");
        String firstName = scan.nextLine();
        System.out.print("Enter lastname:");
        String lastName = scan.nextLine();

        Contact searchContactRecord = contactBook.searchContact(firstName, lastName);

        if(searchContactRecord != null){
            System.out.println("Contact found ");
            System.out.println("Name: " + searchContactRecord.getFirstName() + " " + searchContactRecord.getLastName() +
                    " Telephone number: " + searchContactRecord.getTelephone());
        }
        else{
            System.out.println("Contact not found");
        }
    }

    private void removeContact() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Firstname of contact to be removed: ");
        String firstName = scan.nextLine();
        System.out.print("Enter Lastname of contact to be removed: ");
        String lastName = scan.nextLine();
        boolean contactRemoved = contactBook.removeContact(firstName, lastName);
        if(!contactRemoved) {
            System.out.println("Contact cannot be removed from your contact book");
        }
        else
            System.out.println("contact " + firstName + " removed from contact book");
    }
}
