package org.example.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement the LRUCache class:
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists.
 * Otherwise, add the key-value pair to the cache.
 * If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 * Implementation :
 * we use hashmap and linked list here
 * linkedlist is used to manage the most recent used
 * Hashmap is used to fetch the node in O(1) time
 */
public class LRUCache {

    Map<Integer,Node> map;
    Node head;
    Node tail;
    int size;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        size = capacity;
        head = null;
        tail = null;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            removeNode(node);
            addNode(node);
            map.put(key, node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node node;
        if(map.containsKey(key)) {
            node = map.get(key);
            node.val = value;
            removeNode(node);
        } else {
            node = new Node(key, value);
            if(size<=map.size()){
                map.remove(tail.key);
              removeNode(tail);

            }

        }
        addNode(node);
        map.put(key, node);
    }

    private void addNode(Node node) {
        node.next = head;
        node.prev = null;
        if(head !=null) {
            head.prev = node;
        }
        head = node;
        if(tail == null)
            tail = head;
    }

    private void removeNode(Node node) {
        if(node.next!=null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }

        if(node.prev!=null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
    }


    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }

    }

    public static void main(String[] args) {
        LRUCache obj = new LRUCache(1);
        obj.put(2,2);
        System.out.println(obj.get(2));
        obj.put(3,3);
        System.out.println(obj.get(2));
        System.out.println(obj.get(3));
    }
}
