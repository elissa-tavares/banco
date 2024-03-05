package org.example.infra.messages;

import org.example.infra.messages.colors.Color;

public enum AccountMessage {
    ACCOUNT_ALREADY_EXISTS(Color.RED.get() + "Account already exists" + Color.RESET.get()),
    ACCOUNT_OPEN_SUCCESS(Color.GREEN.get() + "Account opened successfully!" + Color.RESET.get()),
    ACCOUNT_OPEN_FAILURE(Color.RED.get() + "Failed to open the account" + Color.RESET.get()),
    ACCOUNT_NOT_EXIST(Color.RED.get() + "The account does not exist" + Color.RESET.get()),
    DEPOSIT_SUCCESS(Color.GREEN.get() + "Deposit successful!" + Color.RESET.get()),
    DEPOSIT_FAILURE(Color.RED.get() + "Failed to execute" + Color.RESET.get()),
    WITHDRAWAL_SUCCESS(Color.GREEN.get() + "Withdrawal successful!" + Color.RESET.get()),
    WITHDRAWAL_FAILURE(Color.RED.get() + "Failed to withdraw" + Color.RESET.get());


    private final String message;

    AccountMessage(String message) {
        this.message = message;
    }

    public void print() {
        System.out.println(message);
    }
}
