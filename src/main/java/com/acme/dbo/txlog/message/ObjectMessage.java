package com.acme.dbo.txlog.message;

import com.acme.dbo.txlog.Severity;

public class ObjectMessage{
    private Object value;
    private Severity severity;

    public ObjectMessage(Object value, Severity severity) {
        this.value = value;
        this.severity = severity;
    }

    public Object getValue() {
        return value;
    }

    public String decorate() {
        return "reference: " + getValue();
    }
}
