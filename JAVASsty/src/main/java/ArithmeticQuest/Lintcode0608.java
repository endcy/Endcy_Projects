package ArithmeticQuest;

import java.util.Arrays;

/**
 * Created by cxx on 2017/6/7.
 */
public class Lintcode0608 {
    public static void main(String[] args) {
//        System.out.println(triangleCount(new int[]{3, 4,5,5, 6, 7}));
//        System.out.println(stringPermutation("", ""));
        System.out.println(addDigits(99999));
    }

    //给定一个整数数组，在该数组中，寻找三个数，分别代表三角形三条边的长度，问，可以寻找到多少组这样的三个数来组成三角形
    public static int triangleCount(int S[]) {
        Arrays.sort(S);
        int count = 0;
        for (int i = 0; i < S.length - 2; i++) {
            for (int j = i + 1; j < S.length - 1; j++) {
                //三层枚举O(n^3)出现时间超限问题
                int k = j + 1;
                while (k <= S.length - 1 && S[i] + S[j] > S[k]) {
//                    System.out.println(S[i] + " "+ S[j] + " " + S[k] );
                    count++;
                    k++;
                }
            }
        }
        return count;
    }

    //该算法时间复杂度为O(N^3) 不符合要求
    public static int triangleCount2(int S[]) {
        int count = 0;
        for (int i = 0; i < S.length - 2; i++) {
            int len1 = S[i];
            for (int j = i + 1; j < S.length - 1; j++) {
                int len2 = S[j];
                for (int k = j + 1; k < S.length; k++) {
                    int len3 = S[k];
                    boolean x = len1 + len2 > len3 && len2 + len3 > len1 && len1 + len3 > len2;
                    if (x) {
                        count++;
                        //System.out.println(len1 + \"  \" + len2 + \"  \" + len3);
                    }
                }
            }
        }
        return count;
    }

    //给定两个字符串，请设计一个方法来判定其中一个字符串是否为另一个字符串的置换。置换的意思是，通过改变顺序可以使得两个字符串相等。
    public static boolean stringPermutation(String A, String B) {
        char arr1[] = A.toCharArray();
        char arr2[] = B.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return String.valueOf(arr1).equals(String.valueOf(arr2));
    }

    //给出一个非负整数 num，反复的将所有位上的数字相加，直到得到一个一位的整数。
    public static int addDigits(int num) {
        int inc = num;
        while (inc >= 10) {
            num = inc;  //外围二次循环的数返回为inc，但内层循环计算主体为num
            int cell = 0;
            do {    //各位相加
                int temp = num % 10;
                cell += temp;
            } while ((num = num / 10) >= 1);
            cell += num;    //加上最高位的数
            inc = cell;
        }
        return inc;
    }
}
