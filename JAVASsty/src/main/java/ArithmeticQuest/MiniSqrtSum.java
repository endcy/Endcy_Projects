package ArithmeticQuest;

import java.util.Scanner;

/**
 * ***************************************************************************
 * 功能说明：
 * 作    者： ChenXX
 * 创建日期： 2016/11/15
 * 版 本 号： 1.0
 * ***************************************************************************
 */
public class MiniSqrtSum {
    public static int leastSquareSum(int num) {
        int maxone = (int) Math.sqrt(num);
        System.out.println("maxone" + maxone);
        if (maxone * maxone == num) {
            return 1;
        }
        int result = Integer.MAX_VALUE;
        while (maxone > 0) {
            int currentsize = 1 + leastSquareSum(num - maxone * maxone);
            System.out.println("currentsize:" + currentsize);
            result = result < currentsize ? result : currentsize;
            System.out.println("result:" + result);
            maxone--;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        System.out.println(leastSquareSum(x));
    }
}
