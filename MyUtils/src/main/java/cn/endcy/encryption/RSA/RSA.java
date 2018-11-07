package cn.endcy.encryption.RSA;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cxx on 2017/6/28.
 * 介绍：http://blog.csdn.net/wm_1991/article/details/51954565
 * RSA算法速度较慢，比DES至少慢几倍，但实践应用安全性很高，一般用于加密量小的数据
 */
public class RSA {

    /**
     * @param srcArrays
     * @return
     */
    private static byte[] streamCopy(List<byte[]> srcArrays) {
        byte[] destAray = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            for (byte[] srcArray : srcArrays) {
                bos.write(srcArray);
            }
            bos.flush();
            destAray = bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bos.close();
            } catch (IOException e) {
            }
        }
        return destAray;
    }

    /**
     * 根据私钥加密对应字符串
     *
     * @param source
     * @param priKey
     * @return
     * @throws Exception
     */
    public static String encryptStr(String source, Key priKey)
            throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, priKey);
        List<byte[]> bytes = new ArrayList<byte[]>();
        byte[] b = source.getBytes("UTF-8");
        int mod = b.length / 100;
        for (int i = 0; i < mod; i++) {
            // 注意要使用2的倍数，否则会出现加密后的内容再解密时为乱码
            byte[] doFinal = cipher.doFinal(Arrays.copyOfRange(b, i * 100, i * 100 + 100));
            bytes.add(doFinal);
        }
        byte[] doFinal = cipher.doFinal(Arrays.copyOfRange(b, mod * 100, b.length));
        bytes.add(doFinal);
        byte[] newByte = streamCopy(bytes);
        return new BASE64Encoder().encode(newByte);
    }

    /**
     * 根据对应公钥解密数据
     *
     * @param data
     * @param pubKey
     * @return
     * @throws Exception
     */
    public static String decryptStr(String data, Key pubKey)
            throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, pubKey);
        byte[] b = new BASE64Decoder().decodeBuffer(data);
        List<byte[]> bytes = new ArrayList<byte[]>();
        int mod = b.length / 128;
        for (int i = 0; i < mod; i++) {
            byte[] doFinal = cipher.doFinal(Arrays.copyOfRange(b, i * 128, i * 128 + 128));
            bytes.add(doFinal);
        }

        byte[] doFinal = cipher.doFinal(Arrays.copyOfRange(b, mod * 128, b.length));
        bytes.add(doFinal);
        byte[] newByte = streamCopy(bytes);
        //去除多余的空串
        String retStr = new String(newByte, "ISO8859-1").replaceAll("\0", "");
        return new String(retStr.getBytes("ISO8859-1"), "UTF-8");
    }

}