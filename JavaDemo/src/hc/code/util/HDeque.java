package hc.code.util;

public interface HDeque extends HCollection {
    void addFirst(int ele);
    void addLast(int ele);
    int getFirst();
    int getLast();
    void removeFirst();
    void removeLast();
}
