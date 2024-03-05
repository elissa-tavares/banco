package org.example.infra.controller.impl;

import org.example.infra.controller.api.OperationResult;
import org.example.app.messages.AccountMessage;

public class OperationResultImpl implements OperationResult {
    @Override
    public void message(boolean success, AccountMessage successMessage, AccountMessage failureMessage) {
        printMessage(success ? successMessage : failureMessage);
    }

    private void printMessage(AccountMessage message) {
        message.print();
    }
}
