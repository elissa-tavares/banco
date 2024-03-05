package org.example.controller.impl;

import org.example.controller.api.Controller;
import org.example.controller.api.OperationResult;
import org.example.core.withdrawal.Withdrawal;
import org.example.messages.AccountMessage;
import org.example.messages.InputMessage;
import org.example.validations.account.Existing;

import java.math.BigDecimal;
import java.util.Scanner;

public class WithdrawalControllerImpl implements Controller {
    private final Withdrawal withdrawal;
    private final Existing<Long> existingAccount;
    private final OperationResult operationResult;
    private final Scanner scanner;

    public WithdrawalControllerImpl(Withdrawal withdrawal, Existing<Long> existingAccount, OperationResult operationResult, Scanner scanner) {
        this.withdrawal = withdrawal;
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
            boolean successfully = withdrawal.execute(value, accountNumber);
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
