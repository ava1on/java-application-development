package com.acme.dbo.txlog.message;


import com.acme.dbo.txlog.Severity;

public class ByteMessage extends OverflowAccumuatedMessage {
    private byte value;
    private Severity severity;

    public ByteMessage(byte value, Severity severity) {
        super("primitive: ", Byte.MAX_VALUE);
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

    @Override
    public boolean canBeAccumulatedWithMessage(Message message) {
        return false;
    }

    @Override
    public String decorate() {
        return super .decorate(getValue() + "");
    }

    @Override
    public boolean isOverflow(Message message) {
        return (int)this.getValue() + ((ByteMessage)message).getValue() > super.getLimit();
    }

    @Override
    public int getRemainder(Message message) {
        return (int)this.getValue() + ((ByteMessage)message).getValue() - super.getLimit() ;
    }

    @Override
    public OverflowAccumuatedMessage updateValue(int value) {
        return new ByteMessage((byte)value);
    }
}
