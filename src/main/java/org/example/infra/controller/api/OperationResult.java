package org.example.infra.controller.api;

import org.example.app.messages.AccountMessage;

public interface OperationResult {
    void message(boolean success, AccountMessage successMessage, AccountMessage failureMessage);
}
