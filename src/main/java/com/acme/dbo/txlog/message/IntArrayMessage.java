package com.acme.dbo.txlog.message;

import com.acme.dbo.txlog.Severity;

import java.util.Arrays;

public class IntArrayMessage extends PrefixDecoratedMessage {
    private int[] value;
    private Severity severity;

    public IntArrayMessage(int[] value, Severity severity) {
        super("primitives array: ");
        this.value = value;
        this.severity = severity;
    }

    public int[] getValue() {
        return value;
    }

    @Override
    public boolean canBeAccumulatedWithMessage(Message message) {
        return false;
    }

    @Override
    public String decorate() {
        return super.decorate(Arrays.toString(getValue()).replace('[', '{').replace(']', '}'));
    }
}
