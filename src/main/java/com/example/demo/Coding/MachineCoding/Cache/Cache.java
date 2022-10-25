package com.example.demo.Coding.MachineCoding.Cache;

public class Cache {

    private final EvictionPolicy evictionPolicy;
    private final Storage storage;

    public Cache(EvictionPolicy evictionPolicy , Storage storage) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(String key, String value) {
        try {
            this.storage.add(key,value);
            this.evictionPolicy.keyAccessed(key);
        } catch (StorageFullException e) {
            System.out.println("Storage full trying to evict a key");
            evictionPolicy.evictKey(key);
            this.storage.remove(key);
            // After least recently key has been removed try to put back the key we got again.
            put(key,value);
        }

    }

    public String get(String key) throws InvalidKeyException, StorageFullException {
        String value = this.storage.get(key);
        if(value == null) {
            String msg = "Provided key " + key + " not found in Cache";
            throw new InvalidKeyException(msg);
        }
        evictionPolicy.keyAccessed(key);
        return value;
    }
}
