package org.example.infra.controller.impl;

import org.example.gateway.WithdrawalImplGateway;
import org.example.infra.controller.api.Controller;
import org.example.infra.controller.api.OperationResult;
import org.example.app.messages.AccountMessage;
import org.example.app.messages.InputMessage;
import org.example.security.api.ExistingAccount;

import java.math.BigDecimal;
import java.util.Scanner;

public class WithdrawalControllerImpl implements Controller {
    private final WithdrawalImplGateway withdrawalGateway;
    private final ExistingAccount<Integer> existingAccountByNumber;
    private final OperationResult operationResult;
    private final Scanner scanner;

    public WithdrawalControllerImpl(WithdrawalImplGateway withdrawal, ExistingAccount<Integer> existingAccount, OperationResult operationResult, Scanner scanner) {
        this.withdrawalGateway = withdrawal;
        this.existingAccountByNumber = existingAccount;
        this.operationResult = operationResult;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        Integer accountNumber = inputAccountNumber();
        boolean existing = existingAccountByNumber.existing(accountNumber);

        if (existing) {
            BigDecimal value = inputValue();
            boolean successfully = withdrawalGateway.execute(value, accountNumber);
            operationResult.message(successfully, AccountMessage.WITHDRAWAL_SUCCESS, AccountMessage.WITHDRAWAL_FAILURE);
        } else {
            AccountMessage.ACCOUNT_NOT_EXIST.print();
        }
    }

    private BigDecimal inputValue() {
        InputMessage.ENTER_VALUE.print();
        return scanner.nextBigDecimal();
    }

    private Integer inputAccountNumber() {
        InputMessage.ENTER_ACCOUNT_NUMBER.print();
        return scanner.nextInt();
    }
}
