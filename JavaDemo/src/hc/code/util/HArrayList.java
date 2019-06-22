package hc.code.util;

public class HArrayList implements HList {
    private int MAX_LENGTH;
    private int cursor = 0;
    private int[] array;

    public HArrayList(){
        MAX_LENGTH = 10;
        array = new int[MAX_LENGTH];
    }

    private void check(){
        if(cursor == MAX_LENGTH){
            MAX_LENGTH *= 3;
            MAX_LENGTH >>= 1;
            int[] TempArray = new int[MAX_LENGTH];
            System.arraycopy(TempArray,0,array,0,cursor);
            array = TempArray;
        }
    }

    @Override
    public HListIterator listIterator() {
        HArrayListIterator iter = new HArrayListIterator(array,cursor);
        return iter;
    }

    @Override
    public void add(int ele) {
        check();
        array[cursor] = ele;
        cursor++;
    }

    @Override
    public boolean isEmpty() {
        return cursor == 0;
    }

    @Override
    public HIterator iterator() {
        HCollectionIter iter = new HCollectionIter(array, cursor);
        return iter;
    }

    @Override
    public boolean contain(int ele) {
        return false;
    }

    @Override
    public void remove(int ele) {

    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return cursor;
    }

    private class HArrayListIterator implements  HListIterator{
        private int[] iterArray;
        private int length;
        private int curIndex;

        HArrayListIterator(int[] iterArray, int length){
            this.length = length;
            curIndex = 0;
            this.iterArray = iterArray;
        }

        @Override
        public boolean hasPrevious() {
            return curIndex > 0;
        }

        @Override
        public int previous() {
            int e = iterArray[curIndex];
            curIndex = curIndex - 1;
            return e;
        }

        @Override
        public boolean hasNext() {
            return curIndex < length;
        }

        @Override
        public int next() {
            int e = iterArray[curIndex];
            curIndex++;
            return e;
        }
    }

    private class HCollectionIter implements HIterator {

        private int[] arr;
        private int length;
        private int curIndex;

        HCollectionIter(int[] arr, int length){
            this.arr = arr;
            this.length = length;
            curIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return curIndex < length;
        }

        @Override
        public int next() {
            int e = arr[curIndex];
            curIndex = curIndex + 1;
            return e;
        }
    }
}
