package com.acme.dbo.txlog.message;

public abstract class OverflowAccumuatedMessage extends PrefixDecoratedMessage {
    private int limit;

    protected OverflowAccumuatedMessage(String prefix, int limit) {
        super(prefix);
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }

    public abstract boolean isOverflow(Message message);

    public abstract int getRemainder(Message message);

    public abstract OverflowAccumuatedMessage updateValue(int value);
}
