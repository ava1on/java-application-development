package com.acme.dbo.txlog.message;


import com.acme.dbo.txlog.Severity;

public class IntMessage extends OverflowAccumuatedMessage implements AccumulatingMessage {
    private int value;
    private Severity severity;

    public IntMessage(int value, Severity severity) {
        super("primitive: ", Integer.MAX_VALUE);
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
    public IntMessage accumulate(Message message) {
        return new IntMessage(this.getValue() + ((IntMessage)message).getValue());
    }

    @Override
    public boolean canBeAccumulatedWithMessage(Message message) {
        return message instanceof IntMessage;
    }

    @Override
    public String decorate() {
        return super.decorate(this.getValue() + "");
    }


    @Override
    public boolean isOverflow(Message message) {
        return ((long)this.getValue() + ((IntMessage)message).getValue()) > super.getLimit();
    }

    @Override
    public int getRemainder(Message message) {
        return (int)((long)this.getValue() + ((IntMessage) message).getValue() - super.getLimit());
    }

    @Override
    public IntMessage updateValue(int value) {
        return new IntMessage(value);
    }
}
