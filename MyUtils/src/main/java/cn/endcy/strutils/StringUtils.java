package cn.endcy.strutils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by cxx on 2017/6/29.
 */
public class StringUtils extends org.springframework.util.StringUtils{

    public static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static AtomicLong serial = new AtomicLong(1);
    private static Object longs = new Object();

    public static boolean isEmpty(Object str) {
        return str == null || "".equals(str);
    }

    public static boolean isNotEmpty(Object str) {
        return !isEmpty(str);
    }

    /**
     * 删除String对象的所有空格制表符回车换行符
     *
     * @param str
     * @return
     */
    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    /**
     * 线程安全生成递增数字字符串
     *
     * @param length
     * @return
     */
    public static String getSerialNo(int length) {
        double max = Math.pow(10, length);
        String curSerial;
        long sn = serial.getAndIncrement();
        synchronized (longs) {
            if (sn + 1 >= max) {
                sn = 1;
                serial.set(0);
            }
        }
        curSerial = sn + "";
        while (curSerial.length() < length) {
            curSerial = "0" + curSerial;
        }
        return curSerial;
    }

    /**
     * 根据日期+线程安全递增数字-生成20位的序列号
     *
     * @return String
     */
    public static String getNewSeqId() {
        Date date = new Date();
        String str = dateTimeFormat.format(date);
        long timeStamp = System.currentTimeMillis();
        return str + String.valueOf(timeStamp).substring(11, 13) + getSerialNo(4);
    }

    /**
     * 把金额元->分
     *
     * @param sourceAmount
     * @return String
     */
    public static String changeYuan2Cent(String sourceAmount) {
        String amountStr = "";
        double dAmount = Double.valueOf(sourceAmount).doubleValue();
        long lAmount = Math.round(dAmount * 100);
        amountStr = String.valueOf(lAmount);
        return amountStr;
    }

    /**
     * 把金额分->元
     *
     * @param amount
     * @return
     */
    public static String changeCent2Yuan(String amount) {
        return new DecimalFormat("#############0.00").format(Double.parseDouble(amount) / 100);
    }

    /**
     * 金额相加
     *
     * @param amt
     * @param addAmt
     * @return
     */
    public static String addAmt(String amt, String addAmt) {
        amt = isEmpty(amt) ? "0" : amt;
        addAmt = isEmpty(addAmt) ? "0" : addAmt;
        return new BigDecimal(amt).add(new BigDecimal(addAmt)).toString();
    }

    /**
     * 从MAP中获取值，如果不存在则返回空串""
     *
     * @param map
     * @param key
     * @return
     */
    public static String getMapValue(Map map, String key) {
        Object o = map.get(key);
        return o == null ? "" : o.toString();
    }

    public static void main(String[] args) {
        System.out.println(getNewSeqId());
        System.out.println(getSerialNo(10));
    }

}