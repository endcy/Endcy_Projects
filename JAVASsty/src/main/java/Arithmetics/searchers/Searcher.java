package Arithmetics.searchers;

import java.util.Comparator;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2018/8/31.
 * Version      : 1.0
 * ***************************************************************************
 */
public interface Searcher {
    <T> int search(T[] arr, T key, Comparator<T> comparator);

    <T extends Comparable<T>> int search(T[] arr, T key);
}
