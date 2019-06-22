package hc.code.util;

public class HLinkedList implements HList, HDeque {
    private ListNode headNode;
    private ListNode tailNode;
    private int size;

    public HLinkedList(){
        headNode = null;
        tailNode = null;
        size = 0;
    }

    @Override
    public void addFirst(int ele) {
        if(headNode == null){
            headNode = new ListNode(ele);
            tailNode = headNode;
        }else {
            ListNode newNode = new ListNode(ele);
            newNode.next = headNode;
            headNode.previous = newNode;
            headNode  = headNode.previous;
        }size = size + 1;
    }

    @Override
    public void addLast(int ele) {
        add(ele);
    }

    @Override
    public int getFirst() {
        if(headNode == null) return -1;
        return headNode.node;
    }

    @Override
    public int getLast() {
        if(tailNode == null) return -1;
        return tailNode.node;
    }

    @Override
    public void removeFirst() {
        if(headNode != null){
            ListNode nextNode = headNode.next;
            headNode = null;
            headNode = nextNode;
            headNode.previous = null;
            size = size - 1;
        }
    }

    @Override
    public void removeLast() {
        if(tailNode != null){
            ListNode prevNode = tailNode.previous;
            tailNode = null;
            tailNode = prevNode;
            tailNode.next = null;
            size = size - 1;
        }
    }

    @Override
    public HListIterator listIterator() {
        return new HLinkedListIterator();
    }

    @Override
    public void add(int ele) {
        if(headNode == null){
            tailNode = new ListNode(ele);
            headNode = tailNode;
        }else {
            ListNode newNode = new ListNode(ele);
            newNode.previous = tailNode;
            tailNode.next = newNode;
            tailNode = tailNode.next;
        }size = size + 1;
    }

    @Override
    public boolean isEmpty() {
        return headNode == null;
    }

    @Override
    public HIterator iterator() {
        return new HCollectionIterator();
    }

    @Override
    public boolean contain(int ele) {
        ListNode curNode = headNode;
        while (curNode != null){
            if(curNode.node == ele)return true;
            curNode = curNode.next;
        }
        return false;
    }

    @Override
    public void remove(int ele) {
        if(headNode.node == ele){
            removeFirst();
            return;
        }
        ListNode curNode = headNode;
        while(curNode.next != null){
            if(curNode.next.node == ele){
                curNode.next = curNode.next.next;
                curNode.next.previous = curNode;
                size = size - 1;
            }
        }
    }

    @Override
    public void clear() {
        while(headNode != null){
            ListNode nextNode = headNode.next;
            headNode = null;
            headNode = nextNode.next;
            headNode.previous = null;
        }tailNode = null;
    }

    @Override
    public int size() {
        return size;
    }

    private class ListNode {
        ListNode next;
        ListNode previous;
        int node;

        ListNode(int node){
            this.node = node;
            next = null;
            previous = null;
        }
    }

    private class HLinkedListIterator implements HListIterator{

        private ListNode curNode;
        private HLinkedListIterator(){
            curNode = headNode;
        }
        @Override
        public boolean hasPrevious() {
            return curNode != null;
        }

        @Override
        public int previous() {
            int node = curNode.node;
            curNode = curNode.previous;
            return node;
        }

        @Override
        public boolean hasNext() {
            return curNode != null;
        }

        @Override
        public int next() {
            int node = curNode.node;
            curNode = curNode.next;
            return node;
        }
    }

    private class HCollectionIterator implements HIterator {
        private ListNode curNode;

        private HCollectionIterator(){
            curNode = headNode;
        }

        @Override
        public boolean hasNext() {
            return curNode != null;
        }

        @Override
        public int next() {
            int node = curNode.node;
            curNode = curNode.next;
            return node;
        }
    }
}
