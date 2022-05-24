package com.acme.dbo.txlog.message;

import com.acme.dbo.txlog.Severity;

import java.util.Arrays;

public class IntArrayMessage implements Message {
    private static final String PREFIX = "primitives array: ";

    private int[] value;
    private Severity severity;

    public IntArrayMessage(int[] value, Severity severity) {
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
    public String getPrefix() {
        return PREFIX;
    }

    @Override
    public String toString() {
        return Arrays.toString(getValue()).replace('[', '{').replace(']', '}');
    }
}
