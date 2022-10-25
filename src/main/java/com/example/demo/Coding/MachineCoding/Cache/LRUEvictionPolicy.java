package com.example.demo.Coding.MachineCoding.Cache;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LRUEvictionPolicy implements EvictionPolicy{

    private Deque<String> queue;
    Set<String> valuesInMemory;
    protected final int capacity;

    public LRUEvictionPolicy(int capacity) {
        queue = new LinkedList<>();
        valuesInMemory = new HashSet<>();
        this.capacity = capacity;
    }

    @Override
    public void keyAccessed(String key) throws StorageFullException{
        if(queue.size() == capacity) {
            throw new StorageFullException("Storage is full");
        }
        valuesInMemory.add(key);
        queue.addFirst(key);
    }

    @Override
    public void evictKey(String key) {
        String lastElement = queue.removeLast();
        valuesInMemory.remove(lastElement);

    }
}
