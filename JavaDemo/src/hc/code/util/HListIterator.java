package hc.code.util;

public interface HListIterator extends HIterator {
    boolean hasPrevious();
    int previous();
}
