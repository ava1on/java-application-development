package com.acme.dbo.txlog.service;

import com.acme.dbo.txlog.decorator.Decorator;
import com.acme.dbo.txlog.message.*;
import com.acme.dbo.txlog.saver.Saver;

public class LogService {
    private Saver saver;
    private Message currentMessage;
    private Decorator decorator;

    public LogService(Saver saver, Decorator decorator) {
        this.saver = saver;
        this.decorator = decorator;
    }

    public void log(Message message) {
        if (currentMessage == null) {
            currentMessage = message;
            return;
        }
        if (currentMessage.canBeAccumulatedWithMessage(message)) {
            ((AccumulatingMessage)currentMessage).accumulate(message);
        } else {
            saver.save(decorator.decorate(currentMessage));
            currentMessage = message;
        }
    }

    public void flush() {
        saver.save(decorator.decorate(currentMessage));
        currentMessage = null;
    }
}
