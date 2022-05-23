package com.acme.dbo.txlog.message;


import com.acme.dbo.txlog.Severity;

public class StringMessage {
    private final String PREFIX = "string: ";

    private String value;
    private Severity severity;
    private int count;

    public StringMessage(String value, Severity severity) {
        this.value = value;
        this.severity = severity;
        count = 1;
    }

    public StringMessage(String value) {
        this(value, Severity.MINOR);
    }

    public String getValue() {
        return value;
    }

    public Severity getSeverity() {
        return severity;
    }

    public String decorate() {
        if (count == 1) {
            return PREFIX + value;
        } else {
            return String.format("%s %s (x%d)", PREFIX, value, count);
        }
    }

    public void accumulate(StringMessage message) {
        this.count++;
    }
}
