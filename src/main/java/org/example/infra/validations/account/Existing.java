package org.example.infra.validations.account;

public interface Existing<T> {
    boolean existing(T keyValue);
}
