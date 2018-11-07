package Arithmetics.sorters;

import java.util.Comparator;

/**
 * ***************************************************************************
 * Description  : common interface of all sort way
 * Author       : cxx
 * Creation date: 2018/8/31.
 * Version      : 1.0
 * ***************************************************************************
 */
public interface Sorter {
    //数组元素继承了Comparable实现了对比方法
    <T extends Comparable<T>> void sort(T[] list);

    //传入数组元素并且传入一个对比方法类，支持函数式编程
    <T> void sort(T[] list, Comparator<T> comparator);
}
