/**
 * This class implements a controller specifically for handling withdrawal requests.
 * It coordinates user input, interacts with the withdrawal service, and displays informative messages about the operation's result.
 */
package org.example.infra.controller.impl;

import org.example.adapters.service.WithdrawalServiceClient;
import org.example.infra.controller.api.Controller;
import org.example.infra.controller.api.OperationResult;
import org.example.application.messages.AccountMessage;
import org.example.application.messages.InputMessage;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Controller for handling withdrawal operations.
 */
public class WithdrawalControllerImpl implements Controller {

    /**
     * Client for interacting with the withdrawal service.
     */
    private final WithdrawalServiceClient withdrawalServiceClient;

    /**
     * Component for displaying operation results and messages.
     */
    private final OperationResult operationResult;

    /**
     * Scanner for capturing user input.
     */
    private final Scanner scanner;

    /**
     * Constructor for WithdrawalControllerImpl.
     *
     * @param withdrawal       An instance of WithdrawalServiceClient for withdrawal operations.
     * @param operationResult  An instance of OperationResult for handling operation results and messages.
     * @param scanner           A Scanner instance to capture user input.
     */
    public WithdrawalControllerImpl(WithdrawalServiceClient withdrawal, OperationResult operationResult, Scanner scanner) {
        this.withdrawalServiceClient = withdrawal;
        this.operationResult = operationResult;
        this.scanner = scanner;
    }

    /**
     * The main entry point for the controller. Orchestrates the withdrawal process.
     */
    @Override
    public void execute() {
        Integer accountNumber = inputAccountNumber();
        BigDecimal value = inputValue();
        boolean successfully = withdrawalServiceClient.execute(value, accountNumber);
        operationResult.message(successfully, AccountMessage.WITHDRAWAL_SUCCESS, AccountMessage.WITHDRAWAL_FAILURE);
        //AccountMessage.ACCOUNT_NOT_EXIST.print();
    }

    /**
     * Prompts the user for the withdrawal value and returns it as a BigDecimal object.
     *
     * @return The entered withdrawal value.
     */
    private BigDecimal inputValue() {
        InputMessage.ENTER_VALUE.print();
        return scanner.nextBigDecimal();
    }

    /**
     * Prompts the user for the account number and returns it.
     *
     * @return The entered account number.
     */
    private Integer inputAccountNumber() {
        InputMessage.ENTER_ACCOUNT_NUMBER.print();
        return scanner.nextInt();
    }
}
