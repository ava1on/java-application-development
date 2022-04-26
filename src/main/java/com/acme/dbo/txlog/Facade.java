package com.acme.dbo.txlog;

import com.acme.dbo.txlog.decorator.PrefixMessageDecorator;
import com.acme.dbo.txlog.printer.ConsolePrinter;

public class Facade {
    private static String currentStringValue = null;
    private static long accumulator = 0;
    private static final int BYTE_ACCUMULATOR = 2;
    private static final int INT_ACCUMULATOR = 1;
    private static final int STRING_ACCUMULATOR = 0;
    private static Integer mode = null;

    public static void log(int message) {
        updateNumericAccumulator(message, INT_ACCUMULATOR, Integer.MAX_VALUE);
    }

    public static void log(byte message) {
        updateNumericAccumulator(message, BYTE_ACCUMULATOR, Byte.MAX_VALUE);
    }


    public static void log(char message) {
        ConsolePrinter.printMessage(PrefixMessageDecorator.decorateMessage(message));
    }

    public static void log(String message) {
        if (mode == null) {
            initiateStringAccumulator(message);
        } else if (mode != STRING_ACCUMULATOR || !currentStringValue.equals(message)) {
            flush();
            initiateStringAccumulator(message);
        } else {
            accumulator++;
        }

    }

    public static void log(boolean message) {
        ConsolePrinter.printMessage(PrefixMessageDecorator.decorateMessage(message));
    }

    public static void log(Object message) {
        ConsolePrinter.printMessage(PrefixMessageDecorator.decorateMessage(message));
    }

    public static void flush() {
        if (mode == INT_ACCUMULATOR || mode == BYTE_ACCUMULATOR) {
            ConsolePrinter.printMessage(PrefixMessageDecorator.decorateMessage((int) accumulator));
        } else {
            ConsolePrinter.printMessage(PrefixMessageDecorator.decorateMessage(currentStringValue, accumulator));
            currentStringValue = null;
        }
        mode = null;
        accumulator = 0;
    }

    private static void initiateStringAccumulator(String message) {
        mode = STRING_ACCUMULATOR;
        accumulator = 1L;
        currentStringValue = message;
    }

    private static void checkOverflow(int limit) {
        if (accumulator >= limit) {
            ConsolePrinter.printMessage(PrefixMessageDecorator.decorateMessage(limit));
            accumulator -= limit;
        }
    }

    private static void updateNumericAccumulator(int message, int modeN, int limit) {
        if (mode == null) {
            mode = modeN;
            accumulator = (long) message;
            return;
        }

        if (mode != modeN) {
            flush();
            mode = modeN;
        }
        accumulator += message;
        checkOverflow(limit);
    }
}
