package com.acme.dbo.txlog.message;


import com.acme.dbo.txlog.Severity;

public class IntMessage implements AccumulatingMessage {
    private static final String PREFIX = "primitive: ";

    private int value;
    private Severity severity;

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

    @Override
    public void accumulate(Message message) {
        this.value += ((IntMessage)message).getValue();
    }

    @Override
    public boolean canBeAccumulatedWithMessage(Message message) {
        return message instanceof IntMessage;
    }

    public boolean isOverflowWhenAccumulating(IntMessage message) {
        return (long) this.getValue() + message.getValue() > Integer.MAX_VALUE;
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
