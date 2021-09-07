package com.leetcode;

import java.util.Iterator;
import java.util.LinkedList;

public class MyHashMap {
    class Pair{
        private int Key;

        public Pair(int key, int value) {
            Key = key;
            Value = value;
        }

        private int Value;


        public void setKey(int key) {
            Key = key;
        }

        public int getValue() {
            return Value;
        }

        public void setValue(int value) {
            Value = value;
        }
    }

    private static final int base = 769;
    private LinkedList[] data;
    /** Initialize your data structure here. */
    public MyHashMap() {
        data = new LinkedList[base];
        for(int i = 0; i<base; i++){
            data[i] = new LinkedList<Pair>();
        }

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hask = hask(key);

        Iterator<Pair> iterator = data[hask].iterator();

        while (iterator.hasNext()){
            Pair next = iterator.next();
            if (next.Key == key){
                next.setValue(value);
                return;
            }
        }

        data[hask].offerLast(new Pair(key,value));

    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hask = hask(key);
        Iterator<Pair> iterator = data[hask].iterator();

        while (iterator.hasNext()){
            Pair next = iterator.next();
            if (next.Key == key){
                return next.getValue();
            }
        }
        return -1;

    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {

        int hask = hask(key);
        Iterator<Pair> iterator = data[hask].iterator();

        while (iterator.hasNext()){
            Pair next = iterator.next();
            if (next.Key == key) {
                data[hask].remove(next);
                return;
            }
        }
    }

    public static int hask(int key){
        return key % base;
    }

}
