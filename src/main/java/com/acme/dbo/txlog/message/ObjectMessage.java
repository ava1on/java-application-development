package com.acme.dbo.txlog.message;

import com.acme.dbo.txlog.Severity;

public class ObjectMessage implements Message {
    private static final String PREFIX = "reference: ";

    private Object value;
    private Severity severity;

    public ObjectMessage(Object value, Severity severity) {
        this.value = value;
        this.severity = severity;
    }

    public Object getValue() {
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
