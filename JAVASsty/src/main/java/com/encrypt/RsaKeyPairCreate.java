package com.encrypt;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * @author: zhangqc 14-1-6 下午5:50
 */
public class RsaKeyPairCreate {
    public static final String KEY_ALGORITHM = "RSA";

    public static void main(String[] args) throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGen.initialize(1024);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        String pubKey = Base64Utils.encode(publicKey.getEncoded());
        String priKey = Base64Utils.encode(privateKey.getEncoded());

        System.out.println("pubKey=" + pubKey);
        System.out.println("priKey=" + priKey);
        /*
        ObjectOutputStream oos1 = null;
        ObjectOutputStream oos2 = null;
        try {
            //用对象流将生成的密钥写入文件
            oos1 = new ObjectOutputStream(new FileOutputStream(PUBLIC_KEY_FILE));
            oos2 = new ObjectOutputStream(new FileOutputStream(PRIVATE_KEY_FILE));
            oos1.writeObject(publicKey);
            oos2.writeObject(privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (oos1 != null) oos1.close();
            if (oos2 != null) oos2.close();
        }*/
    }
}
