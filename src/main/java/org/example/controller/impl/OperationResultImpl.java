package org.example.controller.impl;

import org.example.controller.api.OperationResult;
import org.example.messages.AccountMessage;

public class OperationResultImpl implements OperationResult {
    @Override
    public void message(boolean success, AccountMessage successMessage, AccountMessage failureMessage) {
        printMessage(success ? successMessage : failureMessage);
    }

    private void printMessage(AccountMessage message) {
        message.print();
    }
}
