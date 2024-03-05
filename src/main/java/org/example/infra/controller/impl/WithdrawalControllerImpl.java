package org.example.infra.controller.impl;

import org.example.service.withdrawal.WithdrawalServiceClient;
import org.example.infra.controller.api.Controller;
import org.example.infra.controller.api.OperationResult;
import org.example.app.messages.AccountMessage;
import org.example.app.messages.InputMessage;

import java.math.BigDecimal;
import java.util.Scanner;

public class WithdrawalControllerImpl implements Controller {
    private final WithdrawalServiceClient withdrawalServiceClient;
    private final OperationResult operationResult;
    private final Scanner scanner;

    public WithdrawalControllerImpl(WithdrawalServiceClient withdrawal, OperationResult operationResult, Scanner scanner) {
        this.withdrawalServiceClient = withdrawal;
        this.operationResult = operationResult;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        Integer accountNumber = inputAccountNumber();
        BigDecimal value = inputValue();
        boolean successfully = withdrawalServiceClient.execute(value, accountNumber);
        operationResult.message(successfully, AccountMessage.WITHDRAWAL_SUCCESS, AccountMessage.WITHDRAWAL_FAILURE);
        //AccountMessage.ACCOUNT_NOT_EXIST.print();
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
