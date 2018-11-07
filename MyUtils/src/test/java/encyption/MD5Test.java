package encyption;

import cn.endcy.encryption.MD5.MD5;
import cn.endcy.encryption.MD5.MD5keyUtil;

/**
 * Created by cxx on 2017/6/29.
 */
public class MD5Test {
    public static void main(String[] args) {
        String str = "test OK 这里是测试#￥%……&* 719734 “”‘’?｛「［③⑼⒅⒋⒗㏒＝⊥??‰≌∝=∶测试结果对比";
        String token = MD5keyUtil.getRandomToken(6);
//        str = "123这里是测试";
        System.out.println("测试字符串：" + str + "   密码token：" + token);
        long start = System.currentTimeMillis();
        String enc = MD5.signStr(str, token);
        long state1 = System.currentTimeMillis() - start;
        boolean denc = MD5.verifySignStr(str, enc, token);
        long state2 = System.currentTimeMillis() - start - state1;

        System.out.println("签名字符串：" + enc);
        System.out.println("验签后结果：" + denc);
        System.out.println("time(ms): signStr-" + state1 + "  verifySignStr-" + state2);
    }
}
