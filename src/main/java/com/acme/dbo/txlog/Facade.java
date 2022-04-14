package com.acme.dbo.txlog;

import com.acme.dbo.txlog.decorator.PrefixMessageDecorator;
import com.acme.dbo.txlog.printer.ConsolePrinter;

public class Facade {
    public static void log(int message) {
        ConsolePrinter.printMessage(PrefixMessageDecorator.decorateMessage(message));
    }

    public static void log(byte message) {
        ConsolePrinter.printMessage(PrefixMessageDecorator.decorateMessage(message));
    }

    public static void log(char message) {
        ConsolePrinter.printMessage(PrefixMessageDecorator.decorateMessage(message));
    }

    public static void log(String message) {
        ConsolePrinter.printMessage(PrefixMessageDecorator.decorateMessage(message));
    }

    public static void log(boolean message) {
        ConsolePrinter.printMessage(PrefixMessageDecorator.decorateMessage(message));
    }

    public static void log(Object message) {
        ConsolePrinter.printMessage(PrefixMessageDecorator.decorateMessage(message));
    }
}
