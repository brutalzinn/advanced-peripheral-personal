package de.srendi.advancedperipherals.common.util;

public class ListUtil {
    public static <T> T getLastElement(final Iterable<T> elements) {
        T lastElement = null;

        for (T element : elements) {
            lastElement = element;
        }

        return lastElement;
    }
    public static <T> T getFirstElement(final Iterable<T> elements) {
        return elements.iterator().next();
    }

}
