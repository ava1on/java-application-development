package com.acme.dbo.txlog.service;

import com.acme.dbo.txlog.message.*;
import com.acme.dbo.txlog.saver.ConsoleSaver;

public class LogService {
    private ConsoleSaver saver;
    private IntMessage intAccumulator;
    private StringMessage stringAccumulator;
    private ByteMessage byteAccumulator;

    public LogService(ConsoleSaver saver) {
        this.saver = saver;
    }

    public void log(IntMessage message) {
        if (stringAccumulator != null || byteAccumulator != null) {
            flush();
        }
        if (intAccumulator == null) {
            intAccumulator = message;
        } else {
            if (intAccumulator.isOverflowWhenAccumulating(message)) {
                saver.save(new IntMessage(Integer.MAX_VALUE).decorate());
                int newValue = (int) ((long)intAccumulator.getValue() + message.getValue() - Integer.MAX_VALUE);
                intAccumulator = new IntMessage(newValue);
            } else {
                intAccumulator.accumulate(message);
            }
        }
    }

    public void log(StringMessage message) {
        if (intAccumulator != null || byteAccumulator != null) {
            flush();
        }
        if (stringAccumulator == null || !stringAccumulator.getValue().equals(message.getValue())) {
            flush();
            stringAccumulator = message;
        } else {
            stringAccumulator.accumulate(message);
        }
    }

    public void log(ByteMessage message) {
        if (intAccumulator != null || stringAccumulator != null) {
            flush();
        }
        if (byteAccumulator == null) {
            byteAccumulator = message;
        } else {
            if (byteAccumulator.isOverflowWhenAccumulating(message)) {
                saver.save(new ByteMessage(Byte.MAX_VALUE).decorate());
                byte newValue = (byte)(byteAccumulator.getValue() + message.getValue() - Byte.MAX_VALUE);
                byteAccumulator = new ByteMessage(newValue);
            } else {
                byteAccumulator.accumulate(message);
            }
        }
    }

    public void log(CharMessage message) {
        saver.save(message.decorate());
    }

    public void log(BooleanMessage message) {
        saver.save(message.decorate());
    }

    public void log(ObjectMessage message) {
        saver.save(message.decorate());
    }

    public void log(IntArrayMessage message) {
        saver.save(message.decorate());
    }

    public void log(IntMatrixMessage message) {
        saver.save(message.decorate());
    }

    public void flush() {
        if(intAccumulator != null) {
            saver.save(intAccumulator.decorate());
            intAccumulator = null;
        }
        if (stringAccumulator != null) {
            saver.save(stringAccumulator.decorate());
            stringAccumulator = null;
        }
        if (byteAccumulator != null) {
            saver.save(byteAccumulator.decorate());
            byteAccumulator = null;
        }
    }
}
