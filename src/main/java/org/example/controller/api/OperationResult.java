package org.example.controller.api;

import org.example.messages.AccountMessage;

public interface OperationResult {
    void message(boolean success, AccountMessage successMessage, AccountMessage failureMessage);
}
