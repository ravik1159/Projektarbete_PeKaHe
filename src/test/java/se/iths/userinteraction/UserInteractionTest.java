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
        UserInteraction ui = new UserInteraction();

        String input = "0";

        InputStream in= new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ui.startMenu();

        assertTrue(outputStreamCaptor.toString().contains("Shutting down"));

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