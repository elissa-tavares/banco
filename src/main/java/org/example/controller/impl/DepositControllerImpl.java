package org.example.controller.impl;

import org.example.controller.api.Controller;
import org.example.controller.api.OperationResult;
import org.example.core.deposit.Deposit;
import org.example.messages.AccountMessage;
import org.example.messages.InputMessage;
import org.example.validations.account.Existing;

import java.math.BigDecimal;
import java.util.Scanner;

public class DepositControllerImpl implements Controller {

    private final Deposit deposit;
    private final Existing<Long> existingAccount;
    private final OperationResult operationResult;
    private final Scanner scanner;

    public DepositControllerImpl(Deposit deposit, Existing<Long> existingAccount, OperationResult operationResult, Scanner scanner) {
        this.deposit = deposit;
        this.existingAccount = existingAccount;
        this.operationResult = operationResult;
        this.scanner = scanner;
    }


    @Override
    public void execute() {
        Long accountNumber = inputAccountNumber();
        boolean existing = existingAccount.existing(accountNumber);

        if (existing) {
            BigDecimal value = inputValue();
            boolean successfully = deposit.execute(value, accountNumber);
            operationResult.message(successfully, AccountMessage.DEPOSIT_SUCCESS, AccountMessage.DEPOSIT_FAILURE);
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
