package com.acme.dbo.txlog.message;

public interface AccumulatingMessage extends Message {
    Message accumulate(Message message);
}
