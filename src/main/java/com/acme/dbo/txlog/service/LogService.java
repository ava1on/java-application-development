package com.acme.dbo.txlog.service;

import com.acme.dbo.txlog.message.*;
import com.acme.dbo.txlog.saver.Saver;

public class LogService {
    private Saver saver;
    private Message currentMessage = new DefaultMessage();

    public LogService(Saver saver) {
        this.saver = saver;
    }

    public void log(Message message) {
        if (currentMessage.canBeAccumulatedWithMessage(message)) {
            if (currentMessage instanceof OverflowAccumuatedMessage
                    && ((OverflowAccumuatedMessage)currentMessage).isOverflow(message)) {
                OverflowAccumuatedMessage currentOverflowMessage = (OverflowAccumuatedMessage)currentMessage;
                int remainder = currentOverflowMessage.getRemainder(message);
                saver.save(currentOverflowMessage.updateValue(currentOverflowMessage.getLimit()).decorate());
                currentMessage = (currentOverflowMessage.updateValue(remainder));
                return;
            }
            currentMessage = ((AccumulatingMessage)currentMessage).accumulate(message);
        } else {
            saver.save(currentMessage.decorate());
            currentMessage = message;
        }
    }

    public void flush() {
        saver.save(currentMessage.decorate());
        currentMessage = new DefaultMessage();
    }
}
