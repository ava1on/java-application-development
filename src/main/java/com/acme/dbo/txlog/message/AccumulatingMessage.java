package com.acme.dbo.txlog.message;

public interface AccumulatingMessage extends Message {
    void accumulate(Message message);
}
