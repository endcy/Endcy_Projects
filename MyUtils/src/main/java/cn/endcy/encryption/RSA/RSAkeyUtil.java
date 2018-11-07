package cn.endcy.encryption.RSA;

import cn.endcy.strutils.Base64Utils;
import sun.misc.BASE64Decoder;

import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Created by cxx on 2017/6/29.
 */
public class RSAkeyUtil {

    public static final String KEY_ALGORITHM = "RSA";

    /**
     * 生成字符串密钥对
     *
     * @return
     * @throws Exception
     */
    public static String[] getRSAkeyStr() throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGen.initialize(1024);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        String pubKey = Base64Utils.encode(publicKey.getEncoded());
        String priKey = Base64Utils.encode(privateKey.getEncoded());
        System.out.println("pubKey=" + pubKey);
        System.out.println("priKey=" + priKey);
        return new String[]{pubKey, priKey};
    }

    /**
     * 生成密钥对
     *
     * @param keyStr 字符串密钥对
     * @return key 公钥:key[0] 私钥:key[1]
     * @throws Exception
     */
    public static Key[] getRSAKeys(String keyStr[]) throws Exception {
        Key key[] = new Key[2];
        if (keyStr[0] != null && !"".equals(keyStr[0])) {
            byte[] keyBytes = new BASE64Decoder().decodeBuffer(keyStr[0]);
            KeySpec keySpec;
            keySpec = new X509EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            key[0] = keyFactory.generatePublic(keySpec);
        }
        if (keyStr[1] != null && !"".equals(keyStr[1])) {
            byte[] keyBytes = new BASE64Decoder().decodeBuffer(keyStr[1]);
            KeySpec keySpec;
            keySpec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            key[1] = keyFactory.generatePrivate(keySpec);
        }
        return key;
    }

    /**
     * 随机自动生成密钥对
     *
     * @return key 公钥:key[0] 私钥:key[1]
     * @throws Exception
     */
    public static Key[] getRSAKeysAuto() throws Exception {
        String keyStr[] = getRSAkeyStr();
        Key key[] = new Key[2];
        if (keyStr[0] != null && !"".equals(keyStr[0])) {
            byte[] keyBytes = new BASE64Decoder().decodeBuffer(keyStr[0]);
            KeySpec keySpec;
            keySpec = new X509EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            key[0] = keyFactory.generatePublic(keySpec);
        }
        if (keyStr[1] != null && !"".equals(keyStr[1])) {
            byte[] keyBytes = new BASE64Decoder().decodeBuffer(keyStr[1]);
            KeySpec keySpec;
            keySpec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            key[1] = keyFactory.generatePrivate(keySpec);
        }
        return key;
    }


}
