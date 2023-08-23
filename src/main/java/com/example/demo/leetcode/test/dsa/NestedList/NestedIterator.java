package com.example.demo.leetcode.test.dsa.NestedList;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class NestedIterator implements Iterator<Integer> {
    Queue<Integer> queue = new LinkedList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        dfs(nestedList);
    }

    private void dfs(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.getInteger() != null) {
                queue.add(nestedInteger.getInteger());
            } else dfs(nestedInteger.getList());
        }
    }

    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
