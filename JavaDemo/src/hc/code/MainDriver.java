package hc.code;

import hc.code.util.HIterator;
import hc.code.util.HLinkedList;
import hc.code.util.HListIterator;

public class MainDriver {
    public static void main(String[] args){
        HLinkedList hLinkedList = new HLinkedList();
        for(int i = 0; i < 100; i++){
            if(i%2==0){
                hLinkedList.add(i);
            }else {
                hLinkedList.addFirst(i);
            }
        }
        HIterator hIterator = hLinkedList.iterator();
        while(hIterator.hasNext()){
            System.out.println(hIterator.next());
        }
    }
}
