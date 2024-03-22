package com.example.dddstart.lock;

public class LockingFailException extends RuntimeException {
    public LockingFailException() {
    }

    public LockingFailException(Throwable cause) {
        super(cause);
    }
}
