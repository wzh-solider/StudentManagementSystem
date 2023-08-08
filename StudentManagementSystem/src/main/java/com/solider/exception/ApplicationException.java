package com.solider.exception;

/**
 * 捕获异常
 * @author Solider
 * @version 1.0
 * @since 1.0
 */
public class ApplicationException extends RuntimeException {
    public ApplicationException(String msg) {
        System.out.println(msg);
    }

    public ApplicationException() {super();}
}
