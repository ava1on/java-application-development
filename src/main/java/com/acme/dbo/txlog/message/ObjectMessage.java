package com.acme.dbo.txlog.message;

import com.acme.dbo.txlog.Severity;

public class ObjectMessage extends PrefixDecoratedMessage {
    private Object value;
    private Severity severity;

    public ObjectMessage(Object value, Severity severity) {
        super("reference: ");
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

    public String decorate() {
        return super.decorate(this.toString());
    }
}
