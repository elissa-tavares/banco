package org.example.infra.controller.impl;

import org.example.core.model.Person;
import org.example.service.open.account.OpenAccountServiceClient;
import org.example.infra.controller.api.Controller;
import org.example.infra.controller.api.OperationResult;
import org.example.app.messages.AccountMessage;
import org.example.app.messages.InputMessage;

import java.time.LocalDate;
import java.util.Scanner;

public class OpenAccountControllerImpl implements Controller {

    private final OpenAccountServiceClient openAnAccountServiceClient;
    private final OperationResult operationResult;
    private final Scanner scanner;

    public OpenAccountControllerImpl(OpenAccountServiceClient openAccount, OperationResult operationResult, Scanner scanner) {
        this.openAnAccountServiceClient = openAccount;
        this.operationResult = operationResult;
        this.scanner = scanner;
    }

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

    private String inputFirstName() {
        InputMessage.FIRST_NAME_INPUT.print();
        return scanner.nextLine();
    }

    private String inputLastName() {
        InputMessage.LAST_NAME_INPUT.print();
        return scanner.nextLine();
    }

    private String inputCPF() {
        InputMessage.CPF_INPUT.print();
        return scanner.nextLine();
    }

    private LocalDate inputDateOfBirth(){
        InputMessage.DATE_OF_BIRTH.print();
        return LocalDate.parse(scanner.nextLine());
    }

}
