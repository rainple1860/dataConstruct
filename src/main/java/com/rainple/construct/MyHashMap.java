package com.rainple.construct;

import java.util.Objects;

public class MyHashMap<K,V> {

    private Node<K,V>[] table;

    public static void main(String[] args) {
        MyHashMap<Integer, Integer> map = new MyHashMap<>();
        for (int i = 0; i < 100; i++) {
            map.put(i,i);
        }
        System.out.println(map.get(94));
    }

    public MyHashMap() {
        table = new Node[16];
    }

    public void put(K k,V v) {
        int hash,p;
        Node<K,V> first = table[p = (hash = hash(k) & (table.length - 1))];
        Node<K,V> node = new Node<>(k,v,hash,null);
        if (first == null) {
            table[p] = node;
            return;
        }
        Node<K,V> curNode = first;
        while (curNode.next != null) {
            curNode = curNode.next;
        }
        curNode.next = node;
    }

    public V get(Object key) {
        int h;
        Node<K,V> f = table[h = hash(key) & (table.length - 1)];
        if (f == null) {
            return null;
        }
        if (f.hash == h && (Objects.equals(key, f.k))) {
            return f.v;
        }
        Node<K,V> n = f.next;
        do {
            if (n != null && Objects.equals(key,n.k)) {
                return n.v;
            }
        }while ((n = n.next) != null);
        return null;
    }

    private int hash(Object k) {
        int h;
        return k == null ? 0 : (h = k.hashCode()) ^ h >>> 16;
    }

    private static class Node<K,V> {
        private K k;
        private V v;
        private int hash;
        private Node<K,V> next;

        public Node(K k,V v,int hash,Node<K,V> next) {
            this.k = k;
            this.v = v;
            this.hash = hash;
            this.next = next;
        }

    }

}
