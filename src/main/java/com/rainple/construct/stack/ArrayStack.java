package com.rainple.construct.stack;

/**
 * 基于数组实现的栈
 */
public class ArrayStack<E> implements Stack<E> {

    private Object[] data;
    private int index = -1;
    private int deep;
    private static final int DEFAULT_CAPACITY = 1 << 4;

    public ArrayStack() {
        deep = DEFAULT_CAPACITY;
        data = new Object[deep];
    }

    public ArrayStack(int capacity) {
        if (capacity <= 0) {
            capacity = DEFAULT_CAPACITY;
        }
        deep = capacity;
        data = new Object[deep];
    }

    /**
     * 添加数据，数组满了就不添加
     * @param e 入栈元素
     * @return
     */
    @Override
    public E push(E e) {
        if (isFull()) {
            System.out.println("栈已满");
            return null;
        }
        data[++index] = e;
        return e;
    }

    /**
     * 弹出元素
     * @return 栈顶元素
     */
    @Override
    public E pop() {
        if (isEmpty()) {
            System.out.println("栈为空");
            return null;
        }
        return (E) data[index--];
    }

    /**
     * 查看栈顶元素
     * @return
     */
    @Override
    public E peek() {
        if (isEmpty()) {
            System.out.println("栈为空");
            return null;
        }
        return (E) data[index];
    }

    /**
     * 栈深度
     * @return
     */
    @Override
    public int size() {
        return index + 1;
    }

    @Override
    public boolean isEmpty() {
        return index <= -1;
    }

    private boolean isFull() {
        return deep == index + 1;
    }
}