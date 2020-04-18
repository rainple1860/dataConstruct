package com.rainple.arithmetic.sort;

/**
 * 选择排序
 */
public class SelectSort extends AbstractSort {

    public static void main(String[] args) {
        AbstractSort selectSort = new SelectSort();
        selectSort.test(80000);
        System.out.println("交换次数：" + selectSort.getCount());
    }

    @Override
    public void sort(Integer[] array) {
        for (int j = 0; j < array.length - 1; j++) {
            Integer min = array[j];
            int index = j;
            for (int i = j; i < array.length; i++) {
                if (min > array[i]) {
                    min = array[i];
                    index = i;
                    increase();
                }
            }
            if (index != j) {
                Integer tmp = array[j];
                array[j] = min;
                array[index] = tmp;
            }
        }
    }
}
