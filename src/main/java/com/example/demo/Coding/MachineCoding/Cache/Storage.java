package com.example.demo.Coding.MachineCoding.Cache;

public interface Storage {

    void add(String key, String value) throws StorageFullException;

    void remove(String key);

    String get(String key);
}
