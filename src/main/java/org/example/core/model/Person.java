package org.example.core.model;

import java.time.LocalDate;

public class Person {
    private String name;
    private String surname;
    private String cpf;
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

    public Person(String name, String surname, String cpf, LocalDate dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.cpf = cpf;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

}
