package com.acme.dbo.txlog.message;

public interface Message {
    boolean canBeAccumulatedWithMessage(Message message);
    String decorate();
}
