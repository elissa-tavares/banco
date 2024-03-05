package org.example.app.messages;

import org.example.app.messages.colors.Color;

public enum InputMessage {
    ENTER_VALUE(Color.YELLOW.get() + "Enter the value: " + Color.RESET.get()),
    ENTER_ACCOUNT_NUMBER(Color.YELLOW.get() + "Enter the account number: " + Color.RESET.get()),
    FIRST_NAME_INPUT(Color.YELLOW.get() + "Enter your first name: " + Color.RESET.get()),
    LAST_NAME_INPUT(Color.YELLOW.get() + "Enter your last name: " + Color.RESET.get()),
    DATE_OF_BIRTH(Color.YELLOW.get() + "Enter your date of birth:  " + Color.RESET.get()),
    CPF_INPUT(Color.YELLOW.get() + "Enter your CPF: " + Color.RESET.get());

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public void print() {
        System.out.print(message);
    }
}
