package com.acme.dbo.txlog.message;

import com.acme.dbo.txlog.Severity;

public class BooleanMessage extends PrefixDecoratedMessage {

    private boolean value;
    private Severity severity;

    public BooleanMessage(boolean value, Severity severity) {
        super("primitive: ");
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
    public String decorate() {
        return super.decorate(getValue() + "");
    }
}
