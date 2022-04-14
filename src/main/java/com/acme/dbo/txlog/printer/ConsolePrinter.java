package com.acme.dbo.txlog.printer;

import com.acme.dbo.txlog.decorator.PrefixMessageDecorator;

public class ConsolePrinter {
    public static void printMessage(String message) {
        System.out.println(message);
    }
}
