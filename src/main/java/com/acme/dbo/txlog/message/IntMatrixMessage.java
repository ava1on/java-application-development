package com.acme.dbo.txlog.message;

import com.acme.dbo.txlog.Severity;

import java.util.Arrays;

public class IntMatrixMessage implements Message {
    private static final String PREFIX = "primitives matrix: ";

    private int[][] value;
    private Severity severity;

    public IntMatrixMessage(int[][] value, Severity severity) {
        this.value = value;
        this.severity = severity;
    }

    public int[][] getValue() {
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
        StringBuilder result =  new StringBuilder("{\n");
        for (int[] temp: getValue()) {
            result.append(Arrays.toString(temp).replace('[', '{').replace(']', '}') + "\n");
        }
        return result.append("}").toString();
    }
}
