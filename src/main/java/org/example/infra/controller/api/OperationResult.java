/**
 * This interface defines a contract for handling the outcome of an operation.
 * It allows for displaying different messages based on whether the operation was successful or not.
 */
package org.example.infra.controller.api;

import org.example.application.messages.AccountMessage;

public interface OperationResult {

    /**
     * Displays a message based on the operation's outcome.
     *
     * @param success         True if the operation was successful, false otherwise.
     * @param successMessage  The message to display if the operation was successful.
     * @param failureMessage  The message to display if the operation failed.
     */
    void message(boolean success, AccountMessage successMessage, AccountMessage failureMessage);
}
