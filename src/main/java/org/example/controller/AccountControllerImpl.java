package org.example.controller;

import org.example.service.deposit.Deposit;
import org.example.service.open_an_account.OpenAnAccount;
import org.example.service.withdrawal.Withdrawal;

import java.math.BigDecimal;
import java.util.Scanner;

public class AccountControllerImpl implements AccountController {

    private final Deposit depositImpl;
    private final OpenAnAccount openAnAccountImpl;
    private final Withdrawal withdrawalImpl;
    private final Scanner scanner;

    public AccountControllerImpl(Deposit depositImpl, OpenAnAccount openAnAccountImpl, Withdrawal withdrawalImpl, Scanner scanner) {
        this.depositImpl = depositImpl;
        this.openAnAccountImpl = openAnAccountImpl;
        this.withdrawalImpl = withdrawalImpl;
        this.scanner = scanner;
    }

    @Override
    public void deposit() {
        Long accountNumber = inputAccountNumber();
        BigDecimal value = inputValue();

        boolean deposited = depositImpl.execute(value, accountNumber);
        //System.out.println(deposited ? "Valor depositado com sucesso!" : "Não foi possivel depositar");
        System.out.println(deposited ? "Valor depositado com sucesso!" : "Conta não encontrada");
    }

    @Override
    public void openAnAccount() {
        Long accountNumber = inputAccountNumber();
        boolean open = openAnAccountImpl.execute(accountNumber);
        System.out.println(open ? "Conta aberta com sucesso!" : "Conta já existente");

    }

    @Override
    public void withdrawal() {
        Long accountNumber = inputAccountNumber();
        BigDecimal value = inputValue();

        boolean drawee = withdrawalImpl.execute(value, accountNumber);
        //System.out.println(drawee ? "Valor sacado com sucesso!" : "Não foi possivel sacar");
        System.out.println(drawee ? "Valor sacado com sucesso!" : "Conta não encontrada");

    }

    private BigDecimal inputValue() {
        System.out.print("Digite o valor: ");
        return scanner.nextBigDecimal();

    }

    private Long inputAccountNumber() {
        System.out.print("Digite o numero da conta: ");
        return scanner.nextLong();
    }
}
