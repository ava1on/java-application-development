package com.acme.dbo.txlog.decorator;

public class PrefixMessageDecorator {
    private static final String PRIMITIVE_PREFIX = "primitive";
    private static final String CHAR_PREFIX = "char";
    private static final String STRING_PREFIX = "string";
    private static final String REFERENCE_PREFIX = "reference";

    public static String decorateMessage(int message) {
        return PRIMITIVE_PREFIX + ": " + message;
    }

    public static String decorateMessage(byte message) {
        return PRIMITIVE_PREFIX + ": " + message;
    }

    public static String decorateMessage(char message) {
        return CHAR_PREFIX + ": " + message;
    }

    public static String decorateMessage(String message, long counter) {
        if (counter == 1) {
            return STRING_PREFIX + ": " + message;
        } else {
            return String.format(STRING_PREFIX + ": %s (x%d)", message, counter);
        }
    }

    public static String decorateMessage(boolean message) {
        return PRIMITIVE_PREFIX + ": " + message;
    }

    public static String decorateMessage(Object message) {
        return REFERENCE_PREFIX + ": " + message;
    }
}
