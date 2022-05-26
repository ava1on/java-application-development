package com.acme.dbo.txlog.message;

import com.acme.dbo.txlog.Severity;

public class CharMessage extends PrefixDecoratedMessage{
    private char value;
    private Severity severity;

    public CharMessage(char value, Severity severity) {
        super("char: ");
        this.value = value;
        this.severity = severity;
    }

    public char getValue() {
        return value;
    }

    @Override
    public boolean canBeAccumulatedWithMessage(Message message) {
        return false;
    }

    @Override
    public String decorate() {
        return super.decorate(this.getValue() + "");
    }
}
