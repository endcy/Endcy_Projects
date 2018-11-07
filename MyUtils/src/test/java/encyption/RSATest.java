package encyption;

import cn.endcy.encryption.RSA.RSA;
import cn.endcy.encryption.RSA.RSAkeyUtil;

import java.security.Key;

/**
 * Created by cxx on 2017/6/28.
 */
public class RSATest {
    public static void main(String[] args) throws Exception {
        String str = "test OK 这里是测试#￥%……&* 719734 “”‘’?｛「［③⑼⒅⒋⒗㏒＝⊥??‰≌∝=∶测试结果对比";
//        str = "123这里是测试";
        System.out.println("测试字符串：" + str);
        long start = System.currentTimeMillis();
        Key key[] = RSAkeyUtil.getRSAKeysAuto();
        long state1 = System.currentTimeMillis() - start;
        String enc2 = RSA.encryptStr(str, key[1]);
        long state2 = System.currentTimeMillis() - start - state1;
        String decStr = RSA.decryptStr(enc2, key[0]);
        long end = System.currentTimeMillis() - start - state1 - state2;
        System.out.println();
        System.out.println(enc2);
        System.out.println("解密字符串：" + decStr);
        System.out.println("time(ms): getKey-" + state1 + "  encryptStr-" + state2 + "  decryptStr-" + end);
    }
}
