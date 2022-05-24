package com.acme.dbo.txlog.message;

import com.acme.dbo.txlog.Severity;

public class CharMessage implements Message {
    private static final String PREFIX = "char: ";

    private char value;
    private Severity severity;

    public CharMessage(char value, Severity severity) {
        this.value = value;
        this.severity = severity;
    }

    public char getValue() {
        return value;
    }

    @Override
    public boolean canBeAccumulatedWithMessage(Message message) {
        return false;
    }

    @Override
    public String getPrefix() {
        return PREFIX;
    }

    @Override
    public String toString() {
        return getValue() + "";
    }
}
