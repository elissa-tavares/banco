package org.example.infra.controller.impl;

import org.example.gateway.WithdrawalImplGateway;
import org.example.infra.controller.api.Controller;
import org.example.infra.controller.api.OperationResult;
import org.example.infra.messages.AccountMessage;
import org.example.infra.messages.InputMessage;
import org.example.infra.validations.account.Existing;

import java.math.BigDecimal;
import java.util.Scanner;

public class WithdrawalControllerImpl implements Controller {
    private final WithdrawalImplGateway withdrawalGateway;
    private final Existing<Long> existingAccount;
    private final OperationResult operationResult;
    private final Scanner scanner;

    public WithdrawalControllerImpl(WithdrawalImplGateway withdrawal, Existing<Long> existingAccount, OperationResult operationResult, Scanner scanner) {
        this.withdrawalGateway = withdrawal;
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

    private Long inputAccountNumber() {
        InputMessage.ENTER_ACCOUNT_NUMBER.print();
        return scanner.nextLong();
    }
}
