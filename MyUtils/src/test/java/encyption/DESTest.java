package encyption;

import cn.endcy.encryption.DES.DES;
import cn.endcy.encryption.DES.DESkeyUtil;

/**
 * Created by cxx on 2017/6/28.
 */
public class DESTest {
    public static void main(String[] args) throws Exception {
        String str = "test OK 这里是测试#￥%……&* 719734 “”‘’?｛「［③⑼⒅⒋⒗㏒＝⊥??‰≌∝=∶测试结果对比";
//        str = "123这里是测试";
        long start = System.currentTimeMillis();
        String key2 = DESkeyUtil.getDesKey(104);
//        key2 = "abcd1236abcd1234abcd1236abcd1234";
        System.out.println("测试字符串：" + str);
        System.out.println("所加密密钥：" + key2);
        long state1 = System.currentTimeMillis() - start;
        String enc2 = DES.encryptStr(str, key2);
        long state2 = System.currentTimeMillis() - start - state1;
        String decStr = DES.decryptStr(enc2, key2);
        long end = System.currentTimeMillis() - start - state1 - state2;
        System.out.println(enc2);
        System.out.println("解密字符串：" + decStr);
        System.out.println("time(ms): getKey-" + state1 + "  encryptStr-" + state2 + "  decryptStr-" + end);
    }
}
