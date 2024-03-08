/**
 * This enum defines predefined messages related to account operations,
 * along with color formatting for enhanced readability in the console.
 */
package org.example.application.messages;

import org.example.application.messages.colors.Color;

public enum AccountMessage {

    /**
     * Indicates that an account with the same identifier already exists.
     */
    ACCOUNT_ALREADY_EXISTS(Color.RED.get() + "Account already exists" + Color.RESET.get()),

    /**
     * Indicates that an account has been successfully opened.
     */
    ACCOUNT_OPEN_SUCCESS(Color.GREEN.get() + "Account opened successfully!" + Color.RESET.get()),

    /**
     * Indicates that an attempt to open an account has failed.
     */
    ACCOUNT_OPEN_FAILURE(Color.RED.get() + "Failed to open the account" + Color.RESET.get()),

    /**
     * Indicates that the specified account does not exist.
     */
    ACCOUNT_NOT_EXIST(Color.RED.get() + "The account does not exist" + Color.RESET.get()),

    /**
     * Indicates that a deposit operation has been successful.
     */
    DEPOSIT_SUCCESS(Color.GREEN.get() + "DepositUseCase successful!" + Color.RESET.get()),

    /**
     * Indicates that a deposit operation has failed.
     */
    DEPOSIT_FAILURE(Color.RED.get() + "Failed to execute" + Color.RESET.get()),

    /**
     * Indicates that a withdrawal operation has been successful.
     */
    WITHDRAWAL_SUCCESS(Color.GREEN.get() + "WithdrawalUseCase successful!" + Color.RESET.get()),

    /**
     * Indicates that a withdrawal operation has failed.
     */
    WITHDRAWAL_FAILURE(Color.RED.get() + "Failed to withdraw" + Color.RESET.get());

    private final String message;

    /**
     * Creates a new AccountMessage instance with the given message.
     *
     * @param message The message to associate with this enum constant.
     */
    AccountMessage(String message) {
        this.message = message;
    }

    /**
     * Prints the message to the console.
     */
    public void print() {
        System.out.println(message);
    }
}
