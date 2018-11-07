package Arithmetics.sorters.BubbleSort;

import Arithmetics.sorters.Sorter;

import java.util.Comparator;

/**
 * ***************************************************************************
 * Description  : 冒泡排序 将最大或最小的数依次排到最后面 前面的数继续排序，遇到
 * 排序例子：
 * 678543
 * 675438
 * 654378
 * 543678
 * 435678
 * 345678
 * Author       : cxx
 * Creation date: 2018/8/31.
 * Version      : 1.0
 * ***************************************************************************
 */
public class BubbleSort implements Sorter {
    @Override
    public <T extends Comparable<T>> void sort(T[] list) {
        boolean swap = true;
        for (int i = 1, len = list.length; i < len && swap; i++) {
            swap = false;
            for (int j = 0; j < len - i; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    T temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swap = true;    //如果发生了一次位置互换就说明可能还没排好，继续循环，如果已经没再发生位置互换，那么说明数组已经排好了
                }
            }
        }
    }

    @Override
    public <T> void sort(T[] list, Comparator<T> comparator) {
        boolean swap = true;
        for (int i = 1, len = list.length; i < len; i++) {
            swap = false;
            for (int j = 0; j < len - i; j++) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    T temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swap = true;
                }
            }
        }
    }
}
