/**
 * This class implements a controller specifically for handling account opening requests.
 * It coordinates user input, interacts with the account opening service, and displays informative messages about the operation's result.
 */
package org.example.infra.controller.impl;

import org.example.core.model.Person;
import org.example.service.open.account.OpenAccountServiceClient;
import org.example.infra.controller.api.Controller;
import org.example.infra.controller.api.OperationResult;
import org.example.app.messages.AccountMessage;
import org.example.app.messages.InputMessage;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Controller for handling account opening operations.
 */
public class OpenAccountControllerImpl implements Controller {

    /**
     * Client for interacting with the account opening service.
     */
    private final OpenAccountServiceClient openAnAccountServiceClient;

    /**
     * Component for displaying operation results and messages.
     */
    private final OperationResult operationResult;

    /**
     * Scanner for capturing user input.
     */
    private final Scanner scanner;

    /**
     * Constructor for OpenAccountControllerImpl.
     *
     * @param openAccount       An instance of OpenAccountServiceClient for opening accounts.
     * @param operationResult   An instance of OperationResult for handling operation results and messages.
     * @param scanner           A Scanner instance to capture user input.
     */
    public OpenAccountControllerImpl(OpenAccountServiceClient openAccount, OperationResult operationResult, Scanner scanner) {
        this.openAnAccountServiceClient = openAccount;
        this.operationResult = operationResult;
        this.scanner = scanner;
    }

    /**
     * The main entry point for the controller. Orchestrates the account opening process.
     */
    @Override
    public void execute() {
        String name = inputFirstName();
        String surname = inputLastName();
        String cpf = inputCPF();
        LocalDate dateOfBirth = inputDateOfBirth();

        Person person = new Person(name, surname, cpf, dateOfBirth);
        boolean successfully = openAnAccountServiceClient.execute(person);
        operationResult.message(successfully, AccountMessage.ACCOUNT_OPEN_SUCCESS, AccountMessage.ACCOUNT_OPEN_FAILURE);
        //AccountMessage.ACCOUNT_ALREADY_EXISTS.print();
    }

    /**
     * Prompts the user for their first name and returns it.
     *
     * @return The entered first name.
     */
    private String inputFirstName() {
        InputMessage.FIRST_NAME_INPUT.print();
        return scanner.nextLine();
    }

    /**
     * Prompts the user for their last name and returns it.
     *
     * @return The entered last name.
     */
    private String inputLastName() {
        InputMessage.LAST_NAME_INPUT.print();
        return scanner.nextLine();
    }

    /**
     * Prompts the user for their CPF and returns it.
     *
     * @return The entered CPF.
     */
    private String inputCPF() {
        InputMessage.CPF_INPUT.print();
        return scanner.nextLine();
    }

    /**
     * Prompts the user for their date of birth and returns it as a LocalDate object.
     *
     * @return The entered date of birth.
     */
    private LocalDate inputDateOfBirth() {
        InputMessage.DATE_OF_BIRTH.print();
        return LocalDate.parse(scanner.nextLine());
    }
}
