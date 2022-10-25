package com.example.demo.Coding.MachineCoding.Cache;

public class Driver {

    public static Cache defaultCache() {
        return new Cache(new LRUEvictionPolicy(4), new HashMapBasedStorage());
    }

    public static void main(String[] args) {
        defaultCache();
    }
}
