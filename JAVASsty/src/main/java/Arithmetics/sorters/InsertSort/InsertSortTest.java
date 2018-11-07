package Arithmetics.sorters.InsertSort;

import Arithmetics.sorters.Sorter;
import targetVO.Member;

import java.util.Comparator;
import java.util.Random;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2018/9/18.
 * Version      : 1.0
 * ***************************************************************************
 */
public class InsertSortTest {

    public static void main(String[] args) {
        Sorter insertSort = new InsertSort();
        Member members[] = new Member[10];
        for (int i = 0; i < 10; i++) {
            int x = new Random().nextInt(20);
            members[i] = new Member(x, "A" + x + "BC");
        }
        printArr(members);
//        insertSort.sort(members);     //效果和下面方法一样
        insertSort.sort(members, new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        printArr(members);
    }

    public static void printArr(Object[] arr) {
        StringBuilder buffer = new StringBuilder("");
        for (int i = 0; i < arr.length; i++) {
            buffer.append(" ").append(arr[i].toString());
        }
        System.out.println(buffer.toString());
    }
}
