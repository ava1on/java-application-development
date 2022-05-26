package com.acme.dbo.txlog.decorator;

import com.acme.dbo.txlog.message.Message;

public class PrefixMessageDecorator implements Decorator {
    @Override
    public String decorate(Message message) {
//        return message.getPrefix() + message;
        return "";
    }
}
