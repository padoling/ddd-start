package com.example.dddstart.common.model;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

public class EmailSet {
    @Getter
    private Set<Email> emails;

    public EmailSet(Set<Email> emails) {
        this.emails = emails;
    }
}
