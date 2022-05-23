package com.acme.dbo.txlog.message;


import com.acme.dbo.txlog.Severity;

public class IntMessage {
    private int value;
    private Severity severity;
    private final String PREFIX = "primitive: ";

    public IntMessage(int value, Severity severity) {
        this.value = value;
        this.severity = severity;
    }

    public IntMessage(int value) {
        this(value, Severity.MINOR);
    }

    public int getValue() {
        return value;
    }

    public Severity getSeverity() {
        return severity;
    }

    public String decorate() {
        return PREFIX + getValue();
    }

    public void accumulate(IntMessage message) {
        this.value += message.getValue();
    }

    public boolean isOverflowWhenAccumulating(IntMessage message) {
        return (long)this.getValue() + message.getValue() > Integer.MAX_VALUE;
    }
}
