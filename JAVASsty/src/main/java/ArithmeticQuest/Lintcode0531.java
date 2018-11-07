package ArithmeticQuest;

import java.util.HashMap;

/**
 * Created by cxx on 2017/5/31.
 */
public class Lintcode0531 {
    public static void main(String[] args) {
        System.out.println(isPalindromeNum(1211));
        getTowSum(new int[]{6, 1, 2, 3, 4, 5, 6, 7}, 7);
    }

    //回文数的定义是，将这个数反转之后，得到的数仍然是同一个数。
    public static boolean isPalindromeNum(int num) {
        char numx[] = String.valueOf(num).toCharArray();
        for (int i = 0; i < numx.length / 2; i++) {
            if (numx[i] != numx[numx.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    //给一个整数数组，找到两个数使得他们的和等于一个给定的数 target。
    //你需要实现的函数twoSum需要返回这两个数的下标, 并且第一个下标小于第二个下标。注意这里下标的范围是 1 到 n，不是以 0 开头。
    public static int[] getTowSum(int[] numbers, int target) {
        int arr[] = new int[2];
//        for (int i = 0; i < numbers.length - 1; i++) {
//            for (int j = i + 1; j < numbers.length; j++)
//                if (numbers[i] + numbers[j] == target) {
//                    System.out.println(numbers[i] + "    " + numbers[j]);
//                    arr[0] = i + 1;
//                    arr[1] = j + 1;
//                    return arr;
//                }
//        }
        //containsKey时间复杂度为O(1) 提高效率
        HashMap map = new HashMap();
        for (int x = 1; x < numbers.length; x++)
            map.put(numbers[x], x);
        for (int y = 0; y < numbers.length - 1; y++) {
            if (map.containsKey(target - numbers[y]) && y < Integer.valueOf(map.get(target - numbers[y]).toString())) {
                arr[0] = y + 1;
                arr[1] = Integer.valueOf(map.get(target - numbers[y]).toString()) + 1;
                System.out.println(numbers[arr[0]-1] + "    " + numbers[arr[1]-1]);
                return arr;
            }
        }
        return arr;
    }
}
