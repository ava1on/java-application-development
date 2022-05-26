package com.acme.dbo.txlog.message;

import com.acme.dbo.txlog.Severity;

import java.util.Arrays;

public class IntMatrixMessage extends PrefixDecoratedMessage {
    private int[][] value;
    private Severity severity;

    public IntMatrixMessage(int[][] value, Severity severity) {
        super("primitives matrix: ");
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
    public String decorate() {
        StringBuilder result =  new StringBuilder("{\n");
        for (int[] temp: getValue()) {
            result.append(Arrays.toString(temp).replace('[', '{').replace(']', '}') + "\n");
        }
        return super.decorate(result.append("}").toString());
    }
}
