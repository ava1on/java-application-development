package com.acme.dbo.txlog.message;

import com.acme.dbo.txlog.Severity;

public class BooleanMessage implements Message {
    private static final String PREFIX = "primitive: ";

    private boolean value;
    private Severity severity;

    public BooleanMessage(boolean value, Severity severity) {
        this.value = value;
        this.severity = severity;
    }

    public boolean getValue() {
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
