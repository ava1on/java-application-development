package com.acme.dbo.txlog.message;

import com.acme.dbo.txlog.Severity;

public class CharMessage {
    private char value;
    private Severity severity;

    public CharMessage(char value, Severity severity) {
        this.value = value;
        this.severity = severity;
    }

    public char getValue() {
        return value;
    }

    public String decorate() {
        return "char: " + this.getValue();
    }
}
