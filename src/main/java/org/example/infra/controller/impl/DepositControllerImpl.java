package org.example.infra.controller.impl;

import org.example.gateway.DepositImplGateway;
import org.example.infra.controller.api.Controller;
import org.example.infra.controller.api.OperationResult;
import org.example.infra.messages.AccountMessage;
import org.example.infra.messages.InputMessage;
import org.example.infra.validations.account.Existing;

import java.math.BigDecimal;
import java.util.Scanner;

public class DepositControllerImpl implements Controller {

    private final DepositImplGateway depositGateway;
    private final Existing<Long> existingAccount;
    private final OperationResult operationResult;
    private final Scanner scanner;

    public DepositControllerImpl(DepositImplGateway deposit, Existing<Long> existingAccount, OperationResult operationResult, Scanner scanner) {
        this.depositGateway = deposit;
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
            boolean successfully = depositGateway.execute(value, accountNumber);
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
