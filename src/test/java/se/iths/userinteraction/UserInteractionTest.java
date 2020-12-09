package se.iths.userinteraction;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class UserInteractionTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final InputStream standardIn = System.in;
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
        System.setIn(standardIn);
    }

    @Test
    void testChoiceSwitch() {
        ui.choiceSwitch(5); // input 5 visar menyn
        assertTrue(outputStreamCaptor.toString().contains("0 - to shutdown")); // "0 - to shutdown" borde vara första raden av menyn
    }

    @Test
    void testNameHasCorrectFormat_EmptyString() {
        assertFalse(ui.nameHasCorrectFormat("   "));
    }

    @Test
    void testNameHasCorrectFormat_NameWithDotandSpace() {
        assertTrue(ui.nameHasCorrectFormat("Donald Jr."));
    }

    @Test
    void testPhoneNumberHasCorrectFormat() {
        assertTrue(ui.phoneNumberHasCorrectFormat("070-1234568"));
    }

    @Test
    void testValidInput_WhenInvalidInputGiven() {
        assertFalse(ui.validInput("5464"));
    }
}