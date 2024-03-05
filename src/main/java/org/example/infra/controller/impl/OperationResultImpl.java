/**
 * This class implements the `OperationResult` interface, providing a way to display messages based on the outcome of an operation.
 */
package org.example.infra.controller.impl;

import org.example.infra.controller.api.OperationResult;
import org.example.app.messages.AccountMessage;

public class OperationResultImpl implements OperationResult {

    /**
     * Displays a message based on the operation's success or failure.
     *
     * @param success         True if the operation was successful, false otherwise.
     * @param successMessage  The message to display if the operation was successful.
     * @param failureMessage  The message to display if the operation failed.
     */
    @Override
    public void message(boolean success, AccountMessage successMessage, AccountMessage failureMessage) {
        printMessage(success ? successMessage : failureMessage);
    }

    /**
     * Helper method for printing the actual message content.
     *
     * @param message The message object to be printed, likely utilizing colors or formatting.
     */
    private void printMessage(AccountMessage message) {
        message.print();
    }
}
