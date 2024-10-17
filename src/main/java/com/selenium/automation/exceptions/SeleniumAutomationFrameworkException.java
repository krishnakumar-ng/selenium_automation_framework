package com.selenium.automation.exceptions;

public class SeleniumAutomationFrameworkException extends RuntimeException {
    /**
     * Constructs an exception with the specified detail message
     *
     * @param message - the details about the exception
     */
    public SeleniumAutomationFrameworkException(String message) {
        super(message);
    }

    /**
     * Constructs an exception with the specified detail message and cause
     *
     * @param message - the details about the exception
     * @param cause   - the customized or enriched stack trace
     */
    public SeleniumAutomationFrameworkException(String message, Throwable cause) {
        super(message, cause);
    }
}
