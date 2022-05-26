package com.acme.dbo.txlog.message;


import com.acme.dbo.txlog.Severity;

import java.util.Objects;

public class StringMessage implements AccumulatingMessage {
    private static final String PREFIX = "string: ";

    private String value;
    private Severity severity;
    private int count;

    public StringMessage(String value, Severity severity) {
        this.value = value;
        this.severity = severity;
        count = 1;
    }

    public StringMessage(String value, Severity severity, int count) {
        this.value = value;
        this.severity = severity;
        this.count = count;
    }

    public StringMessage(String value) {
        this(value, Severity.MINOR);
    }

    public String getValue() {
        return value;
    }

    public Severity getSeverity() {
        return severity;
    }

    @Override
    public StringMessage accumulate(Message message) {
        return new StringMessage(this.getValue(), this.getSeverity(), this.count + 1);
    }

    @Override
    public boolean canBeAccumulatedWithMessage(Message message) {
        return message instanceof StringMessage && Objects.equals(((StringMessage) message).getValue(), this.getValue());
    }

    @Override
    public String getPrefix() {
        return PREFIX;
    }

    @Override
    public String toString() {
        if (count == 1) {
            return PREFIX + value;
        } else {
            return String.format("%s %s (x%d)", PREFIX, value, count);
        }
    }
}
