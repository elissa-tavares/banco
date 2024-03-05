package org.example.security.api;

public interface ExistingAccount<T> {
    boolean existing(T keyValue);
}
