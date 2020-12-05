package se.iths.userinteraction;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class UserInteractionTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void startMenu() {

        StringWriter expectedStringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(expectedStringWriter);

        printWriter.println("Menu:\n---------------");
        printWriter.println("0 - to shutdown");
        printWriter.println("1 - Print contacts");
        printWriter.println("2 - Add new contact");
        printWriter.println("3 - Remove existing contact");
        printWriter.println("4 - Search contact");
        printWriter.println("5 - Print menu");
        printWriter.print("\nMake a choice (5 to show menu again): ");
        printWriter.print("\nShutting down..");
        //printWriter.print("\nYou must make a choice between 0 and 5 (5 to show list again): ");
        printWriter.close();

        String expected = expectedStringWriter.toString();
        UserInteraction ui = new UserInteraction();

        String input = "0";
        //String input = "bad input"; Fungerar ej

       InputStream in= new ByteArrayInputStream(input.getBytes());
       System.setIn(in);
       ui.startMenu();

       assertEquals(expected, outputStreamCaptor.toString().trim());

       // assertThrows(InputMismatchException.class, () -> {
        //    ui.startMenu();
        //})
    }

    @Test
    void showMenu() {
        fail(" ");
    }

    @Test
    void choiceSwitch() {
        fail(" ");
    }

    @Test
    void addNewContact() {
        fail(" ");
    }

    @Test
    void searchContact() {
        fail(" ");
    }

}