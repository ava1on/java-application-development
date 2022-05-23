package com.acme.dbo.txlog.message;

import com.acme.dbo.txlog.Severity;

import java.util.Arrays;

public class IntArrayMessage {
    private int[] value;
    private Severity severity;

    public IntArrayMessage(int[] value, Severity severity) {
        this.value = value;
        this.severity = severity;
    }

    public int[] getValue() {
        return value;
    }

    public String decorate() {
        return "primitives array: " + Arrays.toString(getValue()).replace('[', '{').replace(']', '}');
    }
}
