package model.ADT;

import exceptions.ADTException;
import exceptions.KeyNotFoundException;

public interface MyIMap <K, V>{
    public V getValue(K key) throws ADTException;
    public boolean containsKey(K key);
    public void put(K key, V value);
}
