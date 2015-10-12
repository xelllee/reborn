package com.xelllee.code.leetcode.others;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 * <p/>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 */
public class LRUCache {

    class Node {
        public int val;
        public Node prev;
        public Node next;

        public Node(int v) {
            val = v;
        }

    }

    private int counter;
    private int cap;

    private HashMap<Integer, Integer> dat;
    private LinkedList<Integer> list;
    private Node head = null, tail = null;

    public LRUCache(int capacity) {

        dat = new HashMap<Integer, Integer>(capacity);
        list = new LinkedList<Integer>();
        cap = capacity;

    }

    public int get(int key) {
        return (dat.containsKey(key)) ? dat.get(key) : -1;
    }

    public void set(int key, int value) {

        if (counter == cap) {

            int k = tail.val;
            dat.remove(k);
            tail = tail.prev;
            tail.next = null;
            dat.put(key, value);

        } else {
            dat.put(key, value);

            Node node = new Node(key);

            if (head == null) {
                head = node;
                tail = node;
            } else {
                node.next = head;
                head = node;
            }


        }

        counter++;


    }
}