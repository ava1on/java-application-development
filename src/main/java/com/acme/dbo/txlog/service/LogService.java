package com.acme.dbo.txlog.service;

import com.acme.dbo.txlog.decorator.Decorator;
import com.acme.dbo.txlog.message.*;
import com.acme.dbo.txlog.saver.Saver;

public class LogService {
    private Saver saver;
    private Message currentMessage = new DefaultMessage();
    private Decorator decorator;

    public LogService(Saver saver, Decorator decorator) {
        this.saver = saver;
        this.decorator = decorator;
    }

    public void log(Message message) {
        if (currentMessage.canBeAccumulatedWithMessage(message)) {
            currentMessage = ((AccumulatingMessage)currentMessage).accumulate(message);
        } else {
            saver.save(decorator.decorate(currentMessage));
            currentMessage = message;
        }
    }

    public void flush() {
        saver.save(decorator.decorate(currentMessage));
        currentMessage = new DefaultMessage();
    }
}
