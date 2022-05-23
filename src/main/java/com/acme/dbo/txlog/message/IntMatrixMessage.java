package com.acme.dbo.txlog.message;

import com.acme.dbo.txlog.Severity;

import java.util.Arrays;

public class IntMatrixMessage {
    private int[][] value;
    private Severity severity;

    public IntMatrixMessage(int[][] value, Severity severity) {
        this.value = value;
        this.severity = severity;
    }

    public int[][] getValue() {
        return value;
    }

    public String decorate() {
        StringBuilder result =  new StringBuilder("primitives matrix: {\n");
        for (int[] temp: getValue()) {
            result.append(Arrays.toString(temp).replace('[', '{').replace(']', '}') + "\n");
        }
        return result.append("}").toString();
    }
}
