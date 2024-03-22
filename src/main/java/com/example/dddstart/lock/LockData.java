package com.example.dddstart.lock;

import lombok.Getter;

@Getter
public class LockData {
    private String type;
    private String id;
    private String lockId;
    private long expirationTime;

    public LockData(String type, String id, String lockId, long expirationTime) {
        this.type = type;
        this.id = id;
        this.lockId = lockId;
        this.expirationTime = expirationTime;
    }

    public boolean isExpired() {
        return expirationTime < System.currentTimeMillis();
    }
}
