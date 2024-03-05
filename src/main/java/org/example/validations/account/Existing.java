package org.example.validations.account;

public interface Existing<T> {
    boolean existing(T keyValue);
}
