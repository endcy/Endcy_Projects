package Arithmetics.sorters.InsertSort;

import Arithmetics.sorters.Sorter;

import java.util.Comparator;

/**
 * ***************************************************************************
 * Description  : 类似扑克牌插入顺序，第二个元素开始，跟前面的元素依次比较如果较小(大)则替换，最终每一个元素都比较完成排好序。
 *                优化方案为直接查找出前面排好序的数组中所有比新元素（新牌）大（小）的元素X，依次后移一位然后X替换为新元素（新牌）。
 * Author       : cxx
 * Creation date: 2018/9/18.
 * Version      : 1.0
 * ***************************************************************************
 */
public class InsertSort implements Sorter {
    @Override
    public <T extends Comparable<T>> void sort(T[] list) {
        for (int i = 1; i < list.length; i++) {
            T now = list[i];
            for (int j = i - 1; j >= 0; j--) {
                if (now.compareTo(list[j]) < 0) {
                    list[j + 1] = list[j];
                    list[j] = now;
                }
            }
        }
    }

    @Override
    public <T> void sort(T[] list, Comparator<T> comparator) {
        for (int i = 1; i < list.length; i++) {
            T temp = list[i];
            for (int j = i - 1; j >= 0; j--) {
                if (comparator.compare(temp, list[j]) < 0) {
                    list[j + 1] = list[j];
                    list[j] = temp;
                }
            }
        }
    }
}
