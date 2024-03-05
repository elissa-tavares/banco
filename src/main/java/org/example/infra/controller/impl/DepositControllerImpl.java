package org.example.infra.controller.impl;

import org.example.service.client.DepositServiceClient;
import org.example.infra.controller.api.Controller;
import org.example.infra.controller.api.OperationResult;
import org.example.app.messages.AccountMessage;
import org.example.app.messages.InputMessage;

import java.math.BigDecimal;
import java.util.Scanner;

public class DepositControllerImpl implements Controller {

    private final DepositServiceClient depositServiceClient;
    private final OperationResult operationResult;
    private final Scanner scanner;

    public DepositControllerImpl(DepositServiceClient deposit, OperationResult operationResult, Scanner scanner) {
        this.depositServiceClient = deposit;
        this.operationResult = operationResult;
        this.scanner = scanner;
    }


    @Override
    public void execute() {
        Integer accountNumber = inputAccountNumber();
        BigDecimal value = inputValue();
        boolean successfully = depositServiceClient.execute(value, accountNumber);
        operationResult.message(successfully, AccountMessage.DEPOSIT_SUCCESS, AccountMessage.DEPOSIT_FAILURE);
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
