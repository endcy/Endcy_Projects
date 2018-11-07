package ArithmeticQuest;

/**
 * ***************************************************************************
 * Description  : 递归实现字符串反转
 * Author       : cxx
 * Creation date: 2018/4/13.
 * Version      : 1.0
 * ***************************************************************************
 */
public class Str2rtS {

    public static void main(String[] args) {
        System.out.println(reverse("abcdefg1234567"));
    }

    public static String reverse(String str){
        if (str == null || str.length()<=1)
            return str;
        return reverse(str.substring(1)) + str.charAt(0);
    }

}
