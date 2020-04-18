package com.rainple.arithmetic.sort;

/**
 * 冒泡排序
 */
public class BubbleSort extends AbstractSort {

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.test(100000);
        System.out.println("交换次数: " + bubbleSort.getCount());
    }

    @Override
    public void sort(Integer[] array) {

        Integer tmp;
        for (int j = 0 ; j < array.length ; j++) {
            boolean finish = true;
            for (int i = 0; i < array.length - 1 - j; i++) {
                if (array[i] < array[i + 1]) {
                    tmp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = tmp;
                    finish = false;
                    increase();
                }
            }
            if (finish) {
                break;
            }
        }

    }
}
