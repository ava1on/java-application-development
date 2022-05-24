package com.acme.dbo.txlog;

import com.acme.dbo.txlog.decorator.PrefixMessageDecorator;
import com.acme.dbo.txlog.message.*;
import com.acme.dbo.txlog.saver.ConsoleSaver;
import com.acme.dbo.txlog.service.LogService;

public class Facade {
    private static LogService logService = new LogService(new ConsoleSaver(), new PrefixMessageDecorator());

    public static void log(int message) {
        logService.log(new IntMessage(message, Severity.MEDIUM));
    }

    public static void log(String message) {
        logService.log(new StringMessage(message, Severity.MINOR));
    }

    public static void log(byte message) {
        logService.log(new ByteMessage(message, Severity.MINOR));
    }

    public static void log(char message) {
        logService.log(new CharMessage(message,Severity.HIGH));
    }

    public static void log(boolean message) {
        logService.log(new BooleanMessage(message, Severity.MINOR));
    }


    public static void log(int[][] message) {
        logService.log(new IntMatrixMessage(message, Severity.HIGH));
    }

    public static void log(int[] message) {
        logService.log(new IntArrayMessage(message, Severity.HIGH));
    }

    public static void log(Object message) {
        logService.log(new ObjectMessage(message, Severity.MEDIUM));
    }

    public static void log(String... message) {
        for (String s: message) {
            logService.log(new StringMessage(s));
        }
        logService.flush();
    }

    public static void flush() {
        logService.flush();
    }
}
