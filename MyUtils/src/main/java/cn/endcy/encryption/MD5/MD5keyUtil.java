package cn.endcy.encryption.MD5;

import java.util.Random;

/**
 * Created by cxx on 2017/6/29.
 */
public class MD5keyUtil {

    /**
     * 生成用于MD5加密的附加token
     *
     * @param length 表示生成字符串的长度
     * @return
     */
    public static String getRandomToken(int length) {
        String base = "0123456789abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

}
