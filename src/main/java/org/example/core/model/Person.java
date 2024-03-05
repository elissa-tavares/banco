/**
 * This class represents a person. It holds information about a person's name, surname, CPF (Cadastro de Pessoas Físicas - Brazilian individual taxpayer registry number),
 * and date of birth.
 */
package org.example.core.model;

import java.time.LocalDate;

public class Person {

    /**
     * The person's first name.
     */
    private String name;

    /**
     * The person's last name or surname.
     */
    private String surname;

    /**
     * The person's CPF (Cadastro de Pessoas Físicas - Brazilian individual taxpayer registry number).
     */
    private String cpf;

    /**
     * The person's date of birth.
     */
    private LocalDate dateOfBirth;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    /**
     * Constructor for the Person class.
     *
     * @param name       The person's first name.
     * @param surname    The person's last name or surname.
     * @param cpf         The person's CPF (Cadastro de Pessoas Físicas - Brazilian individual taxpayer registry number).
     * @param dateOfBirth The person's date of birth.
     */
    public Person(String name, String surname, String cpf, LocalDate dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.cpf = cpf;
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Retrieves the person's first name.
     *
     * @return The person's first name as a String.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the person's first name.
     *
     * @param name The new first name for the person as a String.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the person's last name or surname.
     *
     * @return The person's last name or surname as a String.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets the person's last name or surname.
     *
     * @param surname The new last name or surname for the person as a String.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Retrieves the person's CPF (Cadastro de Pessoas Físicas - Brazilian individual taxpayer registry number).
     *
     * @return The person's CPF as a String.
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Retrieves the person's date of birth.
     *
     * @return The person's date of birth as a LocalDate object.
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}
