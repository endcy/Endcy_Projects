package ArithmeticQuest;

import java.util.HashMap;
import java.util.Map;

/**
 * ***************************************************************************
 * 鍔熻兘璇存槑锛? * 浣?   鑰咃細 ChenXX
 * 鍒涘缓鏃ユ湡锛?2016/11/15
 * 鐗?鏈?鍙凤細 1.0
 * ***************************************************************************
 */
public class MainTest {
    public static void main(String[] args) {
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s1.intern());
        Map map = new HashMap<String,String>();
        map.put("x", "ok");
        System.out.println(map.get("x").toString());
        System.out.println((String)map.get("y"));
        System.out.println(map.get("y")!=null?(String)map.get("y"):"no");
//        Map<Integer,String> xx= Collections.synchronizedMap(new HashMap<Integer, String>());
        String code = "B001";
        System.out.println(!"B002".equals(code) && !"B001".equals(code));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println((String)map.get("yy"));
    }
}
