package com.example.demo.Coding.MachineCoding.Cache;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage implements Storage{

    Map<String, String> mapStorage = new HashMap<>();
    @Override
    public void add(String key, String value) throws StorageFullException {
        mapStorage.put(key, value);
    }

    @Override
    public void remove(String key) {
        mapStorage.remove(key);
    }

    @Override
    public String get(String key) {
        return mapStorage.get(key);
    }
}
