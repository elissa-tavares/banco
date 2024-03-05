package org.example.controller;

import org.example.messages.AccountMessage;
import org.example.messages.InputMessage;
import org.example.validations.dto.account_number.ExistingAccount;
import org.example.core.deposit.Deposit;
import org.example.core.open_an_account.OpenAnAccount;
import org.example.core.withdrawal.Withdrawal;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Scanner;

public class AccountControllerImpl implements AccountController {

    private final Deposit deposit;
    private final OpenAnAccount openAnAccount;
    private final Withdrawal withdrawal;
    private final ExistingAccount existingAccount;
    private final Scanner scanner;

    public AccountControllerImpl(Deposit depositImpl, OpenAnAccount openAnAccountImpl, Withdrawal withdrawalImpl, ExistingAccount existingAccount, Scanner scanner) {
        this.deposit = depositImpl;
        this.openAnAccount = openAnAccountImpl;
        this.withdrawal = withdrawalImpl;
        this.existingAccount = existingAccount;
        this.scanner = scanner;
    }

    @Override
    public void openAnAccount() {
        Long accountNumber = inputAccountNumber();
        boolean openAccount = existingAccount.existingAccount(accountNumber);

        if (openAccount) {
            AccountMessage.ACCOUNT_ALREADY_EXISTS.print();
        } else {
            boolean successfully = openAnAccount.execute(accountNumber);
            printOperationResult(successfully, AccountMessage.ACCOUNT_OPEN_SUCCESS, AccountMessage.ACCOUNT_OPEN_FAILURE);
        }

    }

    @Override
    public void deposit() {
        Long accountNumber = inputAccountNumber();
        boolean existing = existingAccount.existingAccount(accountNumber);

        if (existing) {
            BigDecimal value = inputValue();
            boolean successfully = deposit.execute(value, accountNumber);
            printOperationResult(successfully, AccountMessage.DEPOSIT_SUCCESS, AccountMessage.DEPOSIT_FAILURE);
        } else {
            AccountMessage.ACCOUNT_NOT_EXIST.print();
        }
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
