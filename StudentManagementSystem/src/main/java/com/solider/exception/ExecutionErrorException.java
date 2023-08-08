package com.solider.exception;

/**
 * 在进行数据操作时，执行出错
 * @author Solider
 * @version 1.0
 * @since 1.0
 */
public class ExecutionErrorException extends Exception {
    public ExecutionErrorException() {
    }

    public ExecutionErrorException(String message) {
        super(message);
    }
}
