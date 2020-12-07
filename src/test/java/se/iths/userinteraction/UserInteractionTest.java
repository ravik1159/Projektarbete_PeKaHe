package se.iths.userinteraction;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
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
    void testStartMenu() {
        /*
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
        printWriter.print("\nYou must make a choice between 0 and 5 (5 to show list again): ");
        printWriter.print("\nShutting down..");
        printWriter.close();
        String expected = expectedStringWriter.toString();
         */

        UserInteraction ui = new UserInteraction();

        String input1 = "bad input";
        String input2 = "0";
        //String sumInput = input1 + System.getProperty("line.separator") + input2 + System.getProperty("line.separator");

        InputStream in= new ByteArrayInputStream(input2.getBytes());
        System.setIn(in);
        ui.startMenu();

        assertTrue(outputStreamCaptor.toString().contains("Shutting down"));
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