package Arithmetics.searchers.BinarySearch;

import targetVO.Member;

import java.util.Comparator;
import java.util.Random;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2018/9/3.
 * Version      : 1.0
 * ***************************************************************************
 */
public class BinarySearchTest {

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int length = 9;
        Member members[] = new Member[length];
        for (int i = 0; i < length; i++) {
            members[i] = new Member(i, i + "ABC");
        }
        int idx = new Random().nextInt(20);
        Member member = new Member(idx, idx + "ABC");
        System.out.println(member);
        printArr(members);
//        int index = binarySearch.search(members, member);
        int index = binarySearch.search(members, member, new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println("-------- INDEX:" + index);
    }

    public static void printArr(Object[] arr) {
        StringBuilder buffer = new StringBuilder("");
        for (int i = 0; i < arr.length; i++) {
            buffer.append(arr[i].toString()).append(" ");
        }
        System.out.println(buffer.toString());
    }
}
