package cn.endcy.encryption.MD5;

import java.security.MessageDigest;

/**
 * Created by cxx on 2017/6/29.
 * 简介：http://blog.csdn.net/ling_du/article/details/51452091
 * 不可逆的签名方式，加入摘要字符串，验签时进行对比，用来判断信息是否遭到篡改
 */
public class MD5 {

    /**
     * 按照指定编码 对字符串进行签名
     *
     * @param dataStr 包含token的待签名串
     * @param encode  指定编码
     * @return
     */
    private static String md5Enc(String dataStr, String encode) {
        StringBuffer sb = new StringBuffer();
        try {
            byte[] data = dataStr.toString().getBytes(encode);
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(data);
            byte[] result = md5.digest();
            byte[] arr$ = result;
            int len$ = result.length;
            for (int i$ = 0; i$ < len$; ++i$) {
                byte b = arr$[i$];
                String hexStr = null;
                int n = b;
                if (b < 0) {
                    n = b & 255;
                }
                hexStr = Integer.toHexString(n / 16) + Integer.toHexString(n % 16);
                sb.append(hexStr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb.toString().toUpperCase();
    }

    /**
     * 返回 true通过  false不通过
     *
     * @param strOrig  待签名字符串
     * @param signData 已签名字符串
     * @param token    签名摘要
     * @return
     */
    public static boolean verifySignStr(String strOrig, String signData, String token) {
        return signData.equals(md5Enc(strOrig + token, "UTF-8"));
    }

    /**
     * 加入摘要签名字符串
     *
     * @param strOrig 待签名字符串
     * @param token 签名摘要
     * @return
     */
    public static String signStr(String strOrig, String token) {
        return md5Enc(strOrig + token, "UTF-8");
    }

}
