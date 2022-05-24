package com.acme.dbo.txlog.message;


import com.acme.dbo.txlog.Severity;

public class ByteMessage implements Message {
    private static final String PREFIX = "primitive: ";

    private byte value;
    private Severity severity;

    public ByteMessage(byte value, Severity severity) {
        this.value = value;
        this.severity = severity;
    }

    public ByteMessage(byte value) {
        this(value, Severity.MINOR);
    }

    public byte getValue() {
        return value;
    }

    public void accumulate(ByteMessage message) {
        this.value += message.getValue();
    }

    public boolean isOverflowWhenAccumulating(ByteMessage message) {
        return this.getValue() + message.getValue() > Byte.MAX_VALUE;
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
        return getValue() + "";
    }
}
