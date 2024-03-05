/**
 * This class implements a controller specifically for handling deposit requests.
 * It coordinates user input, interacts with the deposit service, and displays informative messages about the operation's result.
 */
package org.example.infra.controller.impl;

import org.example.service.deposit.DepositServiceClient;
import org.example.infra.controller.api.Controller;
import org.example.infra.controller.api.OperationResult;
import org.example.app.messages.AccountMessage;
import org.example.app.messages.InputMessage;

import java.math.BigDecimal;
import java.util.Scanner;

public class DepositControllerImpl implements Controller {

    /**
     * Reference to the deposit service client for interacting with the deposit functionality.
     */
    private final DepositServiceClient depositServiceClient;

    /**
     * Reference to the operation result component for displaying appropriate messages based on success or failure.
     */
    private final OperationResult operationResult;

    /**
     * Scanner instance for capturing user input from the console.
     */
    private final Scanner scanner;

    /**
     * Constructor for DepositControllerImpl.
     *
     * @param deposit     An instance of DepositServiceClient for deposit operations.
     * @param operationResult  An instance of OperationResult for handling operation results and messages.
     * @param scanner     A Scanner instance to capture user input.
     */
    public DepositControllerImpl(DepositServiceClient deposit, OperationResult operationResult, Scanner scanner) {
        this.depositServiceClient = deposit;
        this.operationResult = operationResult;
        this.scanner = scanner;
    }

    /**
     * The main entry point for the controller. Orchestrates the deposit process.
     * 1. Prompts the user for account number and retrieves it.
     * 2. Prompts the user for deposit value and retrieves it as a BigDecimal object.
     * 3. Calls the deposit service to execute the deposit operation with the provided account number and value.
     * 4. Retrieves the success/failure indication from the service call.
     * 5. Utilizes the operation result component to display a message based on the outcome (success or failure).
     */
    @Override
    public void execute() {
        Integer accountNumber = inputAccountNumber();
        BigDecimal value = inputValue();
        boolean successfully = depositServiceClient.execute(value, accountNumber);
        operationResult.message(successfully, AccountMessage.DEPOSIT_SUCCESS, AccountMessage.DEPOSIT_FAILURE);
        //AccountMessage.ACCOUNT_NOT_EXIST.print();

    }

    /**
     * Prompts the user for the account number, retrieves the input, and returns it as an Integer.
     * Likely utilizes pre-defined messages from InputMessage for consistent formatting (colors).
     *
     * @return The entered account number as an Integer.
     */
    private Integer inputAccountNumber() {
        InputMessage.ENTER_ACCOUNT_NUMBER.print();
        return scanner.nextInt();
    }

    /**
     * Prompts the user for the deposit value, retrieves the input, and returns it as a BigDecimal object.
     * Likely utilizes pre-defined messages from InputMessage for consistent formatting (colors).
     *
     * @return The entered deposit value as a BigDecimal object.
     */
    private BigDecimal inputValue() {
        InputMessage.ENTER_VALUE.print();
        return scanner.nextBigDecimal();
    }
}
