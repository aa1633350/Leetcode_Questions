package com.example.demo.Coding.MachineCoding.Cache;

public interface EvictionPolicy {

    void keyAccessed(String key) throws StorageFullException;
    void evictKey(String key);
}
