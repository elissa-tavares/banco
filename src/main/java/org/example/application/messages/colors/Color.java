package org.example.application.messages.colors;

/**
 * This enum defines a set of ANSI escape codes for common colors used in terminal output.
 * These codes can be used to format text displayed in the console with different colors.
 */
public enum Color {

    /**
     * Resets all color formatting and attributes applied previously.
     */
    RESET("\u001B[0m"),

    /**
     * Sets the text color to red.
     */
    RED("\u001B[31m"),

    /**
     * Sets the text color to green.
     */
    GREEN("\u001B[32m"),

    /**
     * Sets the text color to yellow.
     */
    YELLOW("\u001B[33m"),

    /**
     * Sets the text color to blue.
     */
    BLUE("\u001B[34m"),

    /**
     * Sets the text color to purple.
     */
    PURPLE("\u001B[35m");

    private final String color;

    /**
     * Constructor for the Color enum.
     *
     * @param color The ANSI escape code representing the color.
     */
    Color(String color) {
        this.color = color;
    }

    /**
     * Retrieves the ANSI escape code for this color.
     *
     * @return The ANSI escape code as a String.
     */
    public String get() {
        return color;
    }
}
