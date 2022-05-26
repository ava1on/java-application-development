package com.acme.dbo.txlog.message;


import com.acme.dbo.txlog.Severity;

import java.util.Objects;

public class StringMessage extends PrefixDecoratedMessage implements AccumulatingMessage {
    private String value;
    private Severity severity;
    private int count;

    public StringMessage(String value, Severity severity) {
        this(value, severity, 1);
    }

    public StringMessage(String value, Severity severity, int count) {
        super("string: ");
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
    public String decorate() {
        String value = (count == 1) ? this.getValue() : String.format("%s (x%d)", this.getValue(), count);
        return super.decorate(value);
    }
}
