package com.solider.exception;

/**
 * @author Solider
 * @version 1.0
 * @since 1.0
 */
public class AddStudentException extends RuntimeException {

    public AddStudentException() {
        super();
    }

    public AddStudentException(String message) {
        super(message);
    }
}
