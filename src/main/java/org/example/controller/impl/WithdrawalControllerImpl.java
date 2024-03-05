package org.example.controller.impl;

import org.example.controller.api.WithdrawalController;
import org.example.core.withdrawal.Withdrawal;
import org.example.messages.AccountMessage;
import org.example.messages.InputMessage;
import org.example.validations.dto.account_number.ExistingAccount;

import java.math.BigDecimal;
import java.util.Scanner;

public class WithdrawalControllerImpl implements WithdrawalController {
    private final Withdrawal withdrawal;
    private final ExistingAccount existingAccount;
    private final Scanner scanner;

    public WithdrawalControllerImpl(Withdrawal withdrawal, ExistingAccount existingAccount, Scanner scanner) {
        this.withdrawal = withdrawal;
        this.existingAccount = existingAccount;
        this.scanner = scanner;
    }

    @Override
    public void withdrawal() {
        Long accountNumber = inputAccountNumber();
        boolean existing = existingAccount.existingAccount(accountNumber);

        if (existing) {
            BigDecimal value = inputValue();
            boolean successfully = withdrawal.execute(value, accountNumber);
            printOperationResult(successfully, AccountMessage.WITHDRAWAL_SUCCESS, AccountMessage.WITHDRAWAL_FAILURE);
        } else {
            AccountMessage.ACCOUNT_NOT_EXIST.print();
        }
    }

    private BigDecimal inputValue() {
        InputMessage.ENTER_VALUE.print();
        return scanner.nextBigDecimal();
    }

    private Long inputAccountNumber() {
        InputMessage.ENTER_ACCOUNT_NUMBER.print();
        return scanner.nextLong();
    }

    private void printOperationResult(boolean success, AccountMessage successMessage, AccountMessage failureMessage) {
        printMessage(success ? successMessage : failureMessage);
    }

    private void printMessage(AccountMessage message) {
        message.print();
    }
}
