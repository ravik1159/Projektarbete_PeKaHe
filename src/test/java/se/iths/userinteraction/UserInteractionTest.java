package se.iths.userinteraction;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class UserInteractionTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private UserInteraction ui = new UserInteraction();

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
        String input = "0";

        InputStream in= new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ui.startMenu();

        assertTrue(outputStreamCaptor.toString().contains("Shutting down"));

    }

    @Test
    void showMenu() {
    }

    @Test
    void choiceSwitch() {
    }

    @Test
    void addNewContact() {
    }

    @Test
    void searchContact() {
    }

    @Test
    void nameHasCorrectFormat_EmptyString() {
        String str = "   ";
        assertFalse(ui.nameHasCorrectFormat(str));
    }

    @Test
    void nameHasCorrectFormat_WeirdSymbolsOnly() {
        assertFalse(ui.nameHasCorrectFormat("@£#"));
    }

    @Test
    void phoneNumberHasCorrectFormat() {
        assertTrue(ui.phoneNumberHasCorrectFormat("123654"));
    }

    @Test
    void validInput_WhenInvalidInputGiven() {
        assertFalse(ui.validInput("5464"));
    }
}