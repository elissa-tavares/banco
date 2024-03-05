package org.example.controller;

import org.example.messages.AccountMessage;
import org.example.messages.InputMessage;
import org.example.validations.dto.account_number.ExistingAccount;
import org.example.core.deposit.Deposit;
import org.example.core.open_an_account.OpenAnAccount;
import org.example.core.withdrawal.Withdrawal;

import java.math.BigDecimal;
import java.util.Scanner;

public class AccountControllerImpl implements AccountController {

    private final Deposit depositImpl;
    private final OpenAnAccount openAnAccountImpl;
    private final Withdrawal withdrawalImpl;
    private final ExistingAccount existingAccount;
    private final Scanner scanner;

    public AccountControllerImpl(Deposit depositImpl, OpenAnAccount openAnAccountImpl, Withdrawal withdrawalImpl, ExistingAccount existingAccount, Scanner scanner) {
        this.depositImpl = depositImpl;
        this.openAnAccountImpl = openAnAccountImpl;
        this.withdrawalImpl = withdrawalImpl;
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
            boolean successfully = openAnAccountImpl.execute(accountNumber);
            (successfully ? AccountMessage.ACCOUNT_OPEN_SUCCESS : AccountMessage.ACCOUNT_OPEN_FAILURE).print();
        }

    }

    @Override
    public void deposit() {
        Long accountNumber = inputAccountNumber();
        boolean existing = existingAccount.existingAccount(accountNumber);

        if (existing) {
            BigDecimal value = inputValue();
            (depositImpl.execute(value, accountNumber) ? AccountMessage.DEPOSIT_SUCCESS : AccountMessage.DEPOSIT_FAILURE).print();
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
            (withdrawalImpl.execute(value, accountNumber) ? AccountMessage.WITHDRAWAL_SUCCESS : AccountMessage.WITHDRAWAL_FAILURE).print();
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

}
