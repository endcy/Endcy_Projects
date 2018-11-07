package cn.endcy.encryption.DES;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;


/**
 * Created by cxx on 2017/6/28.
 * 介绍：http://blog.csdn.net/fengbingchun/article/details/42273257
 * DES加密速度较快，但加密安全性不算很高。在某些简单应用中，依旧推荐DES加密算法
 * 注意：DES加密和解密过程中，密钥长度都必须是8的倍数，实际应用中，密钥要高度保密
 */
public class DES {

    /**
     * 加密成byte[]
     *
     * @param datasource byte[]
     * @param password   String
     * @return byte[]
     */
    public static byte[] encrypt(byte[] datasource, String password) throws Exception {
        SecureRandom random = new SecureRandom();
        DESKeySpec desKey = new DESKeySpec(password.getBytes());
        //创建一个密匙工厂，然后用它把DESKeySpec转换成
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey securekey = keyFactory.generateSecret(desKey);
        //Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance("DES");
        //用密匙初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
        //现在，获取数据并加密
        //正式执行加密操作
        return cipher.doFinal(datasource);
    }

    /**
     * 解密为byte[]
     *
     * @param src      byte[]
     * @param password String
     * @return byte[]
     * @throws Exception
     */
    public static byte[] decrypt(byte[] src, String password) throws Exception {
        // DES算法要求有一个可信任的随机数源
        SecureRandom random = new SecureRandom();
        // 创建一个DESKeySpec对象
        DESKeySpec desKey = new DESKeySpec(password.getBytes());
        // 创建一个密匙工厂
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        // 将DESKeySpec对象转换成SecretKey对象
        SecretKey securekey = keyFactory.generateSecret(desKey);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance("DES");
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, random);
        // 真正开始解密操作
        return cipher.doFinal(src);
    }

    /**
     * 将byte数组转换为表示16进制值的字符串， 如：byte[]{8,18}转换为：0813，
     * 和 hexStr2ByteArr(String strIn) 互为可逆的转换过程
     *
     * @param arr 需要转换的byte数组
     * @return 转换后的字符串
     * @throws Exception 本方法不处理任何异常，所有异常全部抛出
     */
    public static String byteArr2HexStr(byte[] arr) throws Exception {
        int iLen = arr.length;
        // 每个byte用两个字符才能表示，所以字符串的长度是数组长度的两倍
        StringBuffer sb = new StringBuffer(iLen * 2);
        for (int i = 0; i < iLen; i++) {
            int intTmp = arr[i];
            // 把负数转换为正数
            while (intTmp < 0) {
                intTmp = intTmp + 256;
            }
            // 小于0F的数需要在前面补0
            if (intTmp < 16) {
                sb.append("0");
            }
            sb.append(Integer.toString(intTmp, 16));
        }
        return sb.toString();
    }

    /**
     * 将表示16进制值的字符串转换为byte数组，
     * 和 byteArr2HexStr(byte[] arr)互为可逆的转换过程
     *
     * @param strIn 需要转换的字符串
     * @return 转换后的byte数组
     */
    public static byte[] hexStr2ByteArr(String strIn) throws Exception {
        byte[] arr = strIn.getBytes();
        int iLen = arr.length;
        // 两个字符表示一个字节，所以字节数组长度是字符串长度除以2
        byte[] arrOut = new byte[iLen / 2];
        for (int i = 0; i < iLen; i = i + 2) {
            String strTmp = new String(arr, i, 2);
            arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
        }
        return arrOut;
    }

    /**
     * 加密字符串并返回
     *
     * @param str 待加密字符串
     * @param key 加密密钥
     * @return
     * @throws Exception
     */
    public static String encryptStr(String str, String key) throws Exception {
        return byteArr2HexStr(encrypt(str.getBytes(), key));
    }

    /**
     * 解密字符串并返回
     *
     * @param encStr 待解密字符串
     * @param key    解密密钥，同加密密钥
     * @return
     * @throws Exception
     */
    public static String decryptStr(String encStr, String key) throws Exception {
        return new String(DES.decrypt(DES.hexStr2ByteArr(encStr), key));
    }

}