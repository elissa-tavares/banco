package org.example.messages.colors;

public enum Color {
    RESET("\u001B[0m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    PURPLE("\u001B[35m");

    private final String color;

    Color(String color) {
        this.color = color;
    }

    public String get() {
        return color;
    }

}

