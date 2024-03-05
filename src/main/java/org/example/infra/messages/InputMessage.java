package org.example.infra.messages;

import org.example.infra.messages.colors.Color;

public enum InputMessage {
    ENTER_VALUE(Color.YELLOW.get() + "Enter the value: " + Color.RESET.get()),
    ENTER_ACCOUNT_NUMBER(Color.YELLOW.get() + "Enter the account number: " + Color.RESET.get());

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public void print() {
        System.out.print(message);
    }
}
