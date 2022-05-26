package com.acme.dbo.txlog.message;

public class DefaultMessage implements AccumulatingMessage {
    @Override
    public Message accumulate(Message message) {
        return message;
    }

    @Override
    public boolean canBeAccumulatedWithMessage(Message message) {
        return true;
    }

    @Override
    public String getPrefix() {
        return "";
    }
}
