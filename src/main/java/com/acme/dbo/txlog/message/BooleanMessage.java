package com.acme.dbo.txlog.message;

import com.acme.dbo.txlog.Severity;

public class BooleanMessage {
    private boolean value;
    private Severity severity;

    public BooleanMessage(boolean value, Severity severity) {
        this.value = value;
        this.severity = severity;
    }

    public boolean getValue() {
        return value;
    }

    public String decorate() {
        return "primitive: " + getValue();
    }
}
