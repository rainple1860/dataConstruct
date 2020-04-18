package com.rainple.arithmetic.sort;

public abstract class AbstractSort implements Sort {

    private long count;

    public void test(int size) {
        if (size <= 0) {
            size = 10;
        }
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            int ran = (int)(Math.random() * 10000);
            array[i] = ran;
        }
        System.out.println();
        long start = System.currentTimeMillis();
        sort(array);
        System.out.printf("排序完成,用时：%d 豪秒",System.currentTimeMillis() - start);
    }

    protected void increase() {
        count++;
    }

    protected long getCount() {
        return count;
    }

}
