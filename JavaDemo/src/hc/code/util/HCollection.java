package hc.code.util;

public interface HCollection {
    void add(int ele);
    boolean isEmpty();
    HIterator iterator();
    boolean contain(int ele);
    void remove(int ele);
    void clear();
    int size();
}
