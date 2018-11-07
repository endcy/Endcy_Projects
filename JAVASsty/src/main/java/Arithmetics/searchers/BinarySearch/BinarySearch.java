package Arithmetics.searchers.BinarySearch;

import Arithmetics.searchers.Searcher;

import java.lang.reflect.Array;
import java.util.Comparator;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2018/8/31.
 * Version      : 1.0
 * ***************************************************************************
 */
public class BinarySearch implements Searcher {
    //循环移位实现
    @Override
    public <T> int search(T[] arr, T key, Comparator<T> comparator) {
        int low = 0;
        int high = arr.length - 1;  //为什么不是arr.length---防止访问0+arr.length索引越界
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (comparator.compare(arr[mid], key) > 0)  //中间的值要大，说明目标在数组左边
                high = mid - 1;
            else if (comparator.compare(arr[mid], key) < 0) //中间的值要小，说明目标在数组右边
                low = mid + 1;
            else return mid;
        }
        return -1;
    }

    //递归实现
    @Override
    public <T extends Comparable<T>> int search(T[] arr, T key) {
        int low = 0;
        int high = arr.length - 1;
        if (high < 0) return -1;  //收纳条件为最后一个长度为1的数组都找不到那么再递归新数组长度为0了。
        int mid = low + ((high - low) >> 1);
        if (arr[mid].compareTo(key) > 0) {
            arr = arrSub(arr, 0, mid);  //复制左边段为新数组，mid这里是下标数字，正好作为新数组长度所以不-1
            return search(arr, key);
        } else if (arr[mid].compareTo(key) < 0) {
            arr = arrSub(arr, mid + 1, arr.length - mid - 1);//复制右半段为新数组
            return (mid + 1) + search(arr, key);    //右半段数组在原始数组中的位置应该加上截取数组的初始索引位
        } else
            return mid;
    }

    public static <T> T[] arrSub(T[] src, int srcPos, int length) {
        T[] newArr = (T[]) Array.newInstance(src.getClass().getComponentType(), length);
        System.arraycopy(src, srcPos, newArr, 0, length);
        return newArr;
    }
}
