package com.acme.dbo.txlog.message;

public abstract class PrefixDecoratedMessage implements Message {
    private String prefix;

    protected PrefixDecoratedMessage(String prefix) {
        this.prefix = prefix;
    }

    protected String decorate(String value) {
        return this.prefix + value;
    }
}
