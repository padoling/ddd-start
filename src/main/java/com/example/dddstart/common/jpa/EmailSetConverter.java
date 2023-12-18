package com.example.dddstart.common.jpa;

import com.example.dddstart.common.model.Email;
import com.example.dddstart.common.model.EmailSet;
import jakarta.persistence.AttributeConverter;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class EmailSetConverter implements AttributeConverter<EmailSet, String> {

    private static final String DELIMITER = ",";

    @Override
    public String convertToDatabaseColumn(EmailSet attribute) {
        if (attribute == null) return null;
        return attribute.getEmails().stream()
                .map(Email::getAddress)
                .collect(Collectors.joining(DELIMITER));
    }

    @Override
    public EmailSet convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;
        String[] emails = dbData.split(DELIMITER);
        Set<Email> emailSet = Arrays.stream(emails)
                .map(Email::new)
                .collect(Collectors.toSet());
        return new EmailSet(emailSet);
    }
}
