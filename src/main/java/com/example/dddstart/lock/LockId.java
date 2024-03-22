package com.example.dddstart.lock;

import lombok.Getter;

@Getter
public class LockId {
    private String value;

    public LockId(String value) {
        this.value = value;
    }
}
