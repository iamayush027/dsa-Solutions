package com.example.demo.leetcode.test.dsa;

import java.util.Iterator;
import java.util.List;

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> itr=null;
    Integer next = null;
    public PeekingIterator(Iterator<Integer> iterator) {
        this.itr = iterator;
        if (hasNext()) next = itr.next();
    }

    public static void main(String[] args) {
        PeekingIterator peekingIterator = new PeekingIterator(List.of(1, 2, 3).iterator()); // [1,2,3]
        peekingIterator.next();    // return 1, the pointer moves to the next element [1,2,3].
        peekingIterator.peek();    // return 2, the pointer does not move [1,2,3].
        peekingIterator.next();    // return 2, the pointer moves to the next element [1,2,3]
        peekingIterator.next();    // return 3, the pointer moves to the next element [1,2,3]
        peekingIterator.hasNext(); // return False
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer currentValue = next;
        if (itr.hasNext()) {
            next = this.itr.next();
        } else next = null;
        return currentValue;
    }

    @Override
    public boolean hasNext() {
        return next != null || itr.hasNext();
    }
}
