/**
 * This enum defines predefined messages used to prompt users for input during application interaction.
 * The messages are pre-formatted with ANSI escape codes from the {@link org.example.app.messages.colors.Color} enum
 * to provide colored output in the console, enhancing readability.
 */
package org.example.app.messages;

import org.example.app.messages.colors.Color;

public enum InputMessage {

    /**
     * Prompts the user to enter a value.
     */
    ENTER_VALUE(Color.YELLOW.get() + "Enter the value: " + Color.RESET.get()),

    /**
     * Prompts the user to enter their account number.
     */
    ENTER_ACCOUNT_NUMBER(Color.YELLOW.get() + "Enter the account number: " + Color.RESET.get()),

    /**
     * Prompts the user to enter their first name.
     */
    FIRST_NAME_INPUT(Color.YELLOW.get() + "Enter your first name: " + Color.RESET.get()),

    /**
     * Prompts the user to enter their last name.
     */
    LAST_NAME_INPUT(Color.YELLOW.get() + "Enter your last name: " + Color.RESET.get()),

    /**
     * Prompts the user to enter their date of birth.
     */
    DATE_OF_BIRTH(Color.YELLOW.get() + "Enter your date of birth:  " + Color.RESET.get()),

    /**
     * Prompts the user to enter their CPF (Cadastro de Pessoas Físicas - Brazilian individual taxpayer registry number).
     */
    CPF_INPUT(Color.YELLOW.get() + "Enter your CPF: " + Color.RESET.get());

    private final String message;

    /**
     * Constructor for the InputMessage enum.
     *
     * @param message The pre-formatted message to display to the user.
     */
    InputMessage(String message) {
        this.message = message;
    }

    /**
     * Prints the message to the console.
     */
    public void print() {
        System.out.print(message);
    }
}
