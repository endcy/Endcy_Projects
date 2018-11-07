package ArithmeticQuest;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by cxx on 2017/6/1.
 */
public class Lintcode0601 {
    public static void main(String[] args) {
//        System.out.println(reverseWords(" abc words mylove is fang"));
//        System.out.println(reverseWords("word"));
//        System.out.println(reverseWord(" abc   words mylove is fang "));
//        System.out.println(reverseWord(" "));
//        System.out.println(singleNumber(new int[]{1, 1, 2, 2, 3, 3, 5, 6, 6, 7, 7}));
//        System.out.println(singleNumber(new int[]{}));
//        System.out.println(singleNumber(new int[]{1}));
        System.out.println(Integer.MAX_VALUE + "  " + Integer.MIN_VALUE);
//        System.out.println(reverseInteger(0));
        System.out.println(atoi("-2147483649"));
        System.out.println(atoi("    52lintcode   "));
        System.out.println(atoi("-1.0"));
        System.out.println(atoi("+1"));
        System.out.println(atoi("   +-1111 "));
        System.out.println(atoi(" 15+4"));
    }

    //给定一个字符串，逐个翻转字符串中的每个单词。反转字母
    public static String reverseWords(String s) {
        String arr[] = s.split(" ");
        int i = 0;
        StringBuffer newStr = new StringBuffer();
        if (s == null || s.replaceAll(" ", "").equals("")) {
            return newStr.toString();
        }
        while (i < arr.length) {
            if (!arr[i].replaceAll(" ", "").equals("")) {
                char word[] = arr[i].toCharArray();
                char temp[] = new char[word.length];
                for (int x = word.length - 1, y = 0; x >= 0; x--, y++) {    //x为下标
                    temp[y] = word[x];
                }
                newStr.append(new String(temp));
                if (i != arr.length - 1) {
                    newStr.append(" ");
                }
            }
            i++;
        }
        return newStr.toString();
    }

    //仅仅反转单词顺序 不反转字母
    public static String reverseWord(String s) {
        String arr[] = s.split(" ");
        StringBuffer newStr = new StringBuffer();
        if (s == null || s.replaceAll(" ", "").equals("")) {
            return newStr.toString();
        }
        int i = arr.length - 1;
        while (i >= 0) {
            if (!arr[i].replaceAll(" ", "").equals("")) {
                newStr.append(arr[i]).append(" ");
            }
            i--;
        }
        if (newStr.toString().lastIndexOf(" ") == newStr.toString().length() - 1) {
            return newStr.toString().substring(0, newStr.toString().length() - 1);
        }
        return newStr.toString();
    }

    //给出2*n + 1 个的数字，除其中一个数字之外其他每个数字均出现两次，找到这个数字。
    public static int singleNumber(int[] A) {
        List set = new LinkedList();
        int temp = 0;
        for (int x : A) {
            Integer i = new Integer(x);
            if (temp != 0 && set.contains(i)) {
                set.remove(i);
            } else
                set.add(i);
            temp++;
        }
        return set.size() > 0 ? Integer.valueOf(set.get(0).toString()) : 0;
    }

    //将一个整数中的数字进行颠倒，当颠倒后的整数溢出时，返回 0 (标记为 32 位整数)。
    public static int reverseInteger(int n) {
        String type = n < 0 ? "-" : "0";
        n = Math.abs(n);
        char temp[] = String.valueOf(n).toCharArray();
        String last = "";
        for (char c : temp) {
            last = c + last;
        }
        int x = 0;
        try {
            x = Integer.parseInt(type + last);
            if (type.equals("-1")) {
                x = x - 2 * x;
            }
        } catch (Exception e) {
            return 0;
        }
        return x;
    }

    //将一个字符串转换为整数。戳过最大取MAX，超过最小取MIN
    public static int atoi(String str) {
        BigDecimal init = new BigDecimal("0.00");
        //str 重组
        str = str.replaceAll(" ", "");
        char arr[] = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (!Character.isDigit(arr[i])) {
                if (i != 0 && Character.isDigit(arr[i - 1]) && arr[i] == '.')//小数点判断
                    ;
                else if (i == 0 && (arr[i] == '-' || arr[i] == '+')) ; //负号
                else
                    arr[i] = ' ';
            } else {
                if (i!=0 && arr[i-1] == ' ') {
                    arr[i] = ' ';
                }
            }
        }
        str = String.valueOf(arr).replaceAll(" ", "");
        try {
            init = new BigDecimal(str);
            str = (int) Double.parseDouble(str) + "";
        } catch (Exception e) {
            return 0;
        }
        if (str.substring(0, 1).equals("-")) {
            return init.compareTo(new BigDecimal(Integer.MIN_VALUE)) == -1 ? Integer.MIN_VALUE : Integer.parseInt(str);
        } else {
            return init.compareTo(new BigDecimal(Integer.MAX_VALUE)) == -1 ? Integer.parseInt(str) : Integer.MAX_VALUE;
        }
    }

}
