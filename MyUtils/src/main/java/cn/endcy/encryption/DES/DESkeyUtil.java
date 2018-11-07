package cn.endcy.encryption.DES;

import java.util.Random;

/**
 * Created by cxx on 2017/6/28.
 */
public class DESkeyUtil {

    /**
     * 默认密钥长度 64位
     */
    public static final int keyLenDefault = 64;

    /**
     * 生成对应长度的字符串密钥
     *
     * @param keyLen
     * @return
     */
    public static String getDesKey(int keyLen) {
        if (!isLegalLen(keyLen)) {
            System.out.println("密钥长度不合法，置为默认64位");
            keyLen = keyLenDefault;
        }
        return getRandomKey(keyLen);
    }

    /**
     * 密钥长度合法性检查 需要被8整除
     *
     * @param keyLen
     * @return
     */
    private static boolean isLegalLen(int keyLen) {
        return keyLen >= 8 && keyLen % 8 == 0 ? true : false;
    }

    /**
     * 随机生成相应长度字符串
     *
     * @param length 表示生成字符串的长度
     * @return
     */
    private static String getRandomKey(int length) {
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
