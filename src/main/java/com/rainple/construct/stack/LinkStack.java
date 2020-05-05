package com.rainple.construct.stack;

/**
 * 基于链表实现的栈
 * @param <E>
 */
public class LinkStack<E> implements Stack<E> {

    private Node<E> head;
    private int size;

    @Override
    public E push(E e) {
        Node<E> node = new Node<>(e);
        if (head == null) {
            head = node;
        }else {
            Node<E> n = head;
            head = node;
            head.next = n;
        }
        size++;
        return e;
    }

    @Override
    public E pop() {
        if (head == null) {
            return null;
        }
        E data = head.data;
        head = head.next;
        size--;
        return data;
    }

    @Override
    public E peek() {
        return head == null ? null : head.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null || size == 0;
    }

    private static class Node<E> {
        E data;
        Node<E> next;

        public Node(E e) {
            data = e;
        }
    }
}