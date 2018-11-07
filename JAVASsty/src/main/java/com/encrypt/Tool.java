package com.encrypt;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by qisai on 2016/1/16.
 */
public class Tool {

    public static String encrypt(String source, Key priKey)
            throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, priKey);
        List<byte[]> bytes = new ArrayList<byte[]>();
        byte[] b = source.getBytes("UTF-8");
        int mod = b.length/100;
        for (int i = 0; i < mod; i++) {
            // 娉ㄦ剰瑕佷娇鐢?鐨勫€嶆暟锛屽惁鍒欎細鍑虹幇鍔犲瘑鍚庣殑鍐呭鍐嶈В瀵嗘椂涓轰贡鐮?
            byte[] doFinal = cipher.doFinal(Arrays.copyOfRange(b, i * 100, i * 100 + 100));
            bytes.add(doFinal);
        }

        byte[] doFinal = cipher.doFinal(Arrays.copyOfRange(b, mod*100,b.length));
        bytes.add(doFinal);
        byte[] newByte = streamCopy(bytes);
        return new BASE64Encoder().encode(newByte);
    }

    public static String decrypt(String data, Key pubKey)
            throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, pubKey);
        //byte[] b = CryptUtil.decodeBase64(data);
        byte[] b = new BASE64Decoder().decodeBuffer(data);
        List<byte[]> bytes = new ArrayList<byte[]>();
        int mod = b.length/128;
        for (int i = 0; i < mod; i++) {
            byte[] doFinal = cipher.doFinal(Arrays.copyOfRange(b, i*128,i*128 + 128));
            bytes.add(doFinal);
        }

        byte[] doFinal = cipher.doFinal(Arrays.copyOfRange(b, mod*128,b.length));
        bytes.add(doFinal);
        byte[] newByte = streamCopy(bytes);
        //鍘婚櫎澶氫綑鐨勭┖涓?
        //return new String(newByte,"UTF-8").replaceAll("\0","");
        String retStr = new String(newByte,"ISO8859-1").replaceAll("\0", "");
        return new String(retStr.getBytes("ISO8859-1"),"UTF-8");
    }

    /**
     *
     * @param keyStr
     * @param type 0 pub 1 pri
     * @return
     * @throws Exception
     */
    public static Key getKeyFromStr(String keyStr,int type)throws Exception{
        byte[] keyBytes = new BASE64Decoder().decodeBuffer(keyStr);
        KeySpec keySpec ;
        if(0 == type){
            keySpec = new X509EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePublic(keySpec);
        }else if(1 == type){
            keySpec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePrivate(keySpec);
        }
        throw new IllegalArgumentException("argument type must be 0 or 1");

    }

    public static byte[] streamCopy(List<byte[]> srcArrays) {
        byte[] destAray = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            for (byte[] srcArray:srcArrays) {
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
     * 绛惧悕
     * @param strOrig 寰呯鍚嶆槑鏂?
     * @param token 鍙ｄ护
     * @return
     */
    public static String sign(String strOrig, String token)
    {
        //return CryptUtil.encodeMD5(strOrig+token);
        return md5Enc(strOrig + token, "UTF-8");
    }

    public static String md5Enc(String dataStr,String encode){

        StringBuffer sb = new StringBuffer();
        try {
            byte[] data = dataStr.toString().getBytes(encode);
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(data);
            byte[] result = md5.digest();
            byte[] arr$ = result;
            int len$ = result.length;
            for(int i$ = 0; i$ < len$; ++i$) {
                byte b = arr$[i$];
                String hexStr = null;
                int n = b;
                if(b < 0) {
                    n = b & 255;
                }
                hexStr = Integer.toHexString(n / 16) + Integer.toHexString(n % 16);
                sb.append(hexStr);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return sb.toString().toUpperCase();
    }



    /**
     * 楠岀 true 鎴愬姛 false 澶辫触
     * @param strOrig  绛惧悕鏄庢枃
     * @param signData 绛惧悕鏁版嵁
     * @param token 鍙ｄ护
     * @return
     */
    public static boolean verifySign(String strOrig ,String signData,String token){
        //return signData.equals(CryptUtil.encodeMD5(strOrig + token));
        return signData.equals(md5Enc(strOrig+token,"UTF-8"));
    }



    public static void main(String[] args) throws Exception{


        String token = "pw1";
        //RSA 1024 绠楁硶瀵嗛挜瀵?
        String pubKeyStr = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCPscakHN+dT+iG7kpW/OYWDr8byNOsGviGWzElscBf+BxLae/8biW2WtIanneu/PK31c3YN/2zDQ/pMaoCAkjCf71itNhgKQevZCaJrXcy3cSxPeoX4uoNvS5htbPisn7uE0LOPbTXQP6U3KPzzBqigCFX4RKgF8Jj28MmX6lUGwIDAQAB";
        String priKeyStr = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAI+xxqQc351P6IbuSlb85hYOvxvI06wa+IZbMSWxwF/4HEtp7/xuJbZa0hqed6788rfVzdg3/bMND+kxqgICSMJ/vWK02GApB69kJomtdzLdxLE96hfi6g29LmG1s+Kyfu4TQs49tNdA/pTco/PMGqKAIVfhEqAXwmPbwyZfqVQbAgMBAAECgYB35ONTJ2xE+9mOS+DnN9ha6y715dkHrvFSWWBmjStwZ7pkCh5dRyJcRucrorFF5nQ2g0RfdkhOT0XJUtEBIBrIPOwl05C0AeJsvKuR7FYzaWj/s6j819v3RfhsA4pJzTOHunqS4CwrqR7WtfX3OCaPivRJDVRfZBJHZvsYWlxw4QJBANNrww8tZCp1392Hkb2PMMP36NGmdkzrmK6JvkAbOPmsRrT2ZpS2XtcmExRiJx18Sy7hrh/jmqL9uQ36R4N1OFkCQQCt/jjLHktkTvHnCsO6bEY6vONnlrVw/JkYuCkxy7lG1CXFmf3cjWtm4nX7GJ+4JryVPGLNSJ3z81Od76zE+qGTAkBnddmrqLPWz34ww3H/iH39uGi3h7VmqPg7mW5/opK8I6EqV1YVujUpJhm6JNotZLDKDWiPdGstDeqsO2kZnJhpAkBA0PmbQTfYsEgRR8NOSVOIQiF8z3ncE119Be3irP/iUNmZWRpm9Q/Tjf1hgvTNBzEtbwdnbevZmwXFSinUX4GdAkEAquH4GfUeUu87JmqbMhWPdaQuayPNdFrgTjC0LuXxln6EruEaZ3RHugbLU3Fx5PipeYgLjPboQBJ/+Ym9VI0REg==";

        Key priKey = Tool.getKeyFromStr(priKeyStr,1);
        Key pubKey = Tool.getKeyFromStr(pubKeyStr,0);

        /*String encData = "GZttcteClZGqEO/gowd9oPR9O+XD6/YnWQKVl5JhqhqHcMHnpcQcq51Z0qotV68SU8DiQlBNGSvH" +
                "phI6yWgQQu6nrBMRAk2wnAt4WojjL2swMGNskLh9YT+Ztzkp0o5w72SPXSdFSMP3l/Ul2IZEug1f" +
                "FQrzu4I90+TT8bKT+whMxrikRxPPSFM/bNDwjpVKs4xFTdNk2uJ4rBlviujGvK1CR6hF9EhyGNAn" +
                "HIwQj+1bTfJY9JO0tbq96OFc0h43YzpOBS3wQ71jS7NJ0c6rY79K60CH+Tl29vH6DIFVLHlZxCiI" +
                "AhsSF5Z5EqnKxrBjELsf1oQSL16bGl0TyfrmlYIGT+9yJh/iaEFg3koGD6ijkRfS34GVEiWdrYQK" +
                "/3aYt1R34FPKk7WghBR8qGfsQ5FS95uiBHE4QxNjSL+6JN2WR/7kdbjK6gNkbjuv98FdkKSWcnKd" +
                "Ve4hC5gbN9joiFbS4d+RWBzLNyDZ1ewJ9spyG4WXUjmPd8u0EdRspwGXUGL6VZzLMLXHlYU6rgHG" +
                "eATefto65Wqhl6P9rcOdNqfF+UvHt3J3OolWcGVcnbiGt1ZHDYifcbdHhgabxqn9ow6SkqSQ0I3B" +
                "lq15884ZZGP3ObDznf3wkuCXtOTlMwYa+RLdTnflSIenTZzwCmfjt1hQDlq/eVboBMI/dMXCLPJ8" +
                "a06gyjRBNSwxoqluKkP4qAQY8d5+HwvFRdfatC3UDW/oGxp3DR1lQSb8ChKluGcS0bpp+mCSqUxp" +
                "1a2cSR3YSWLL+RSnFXXa9oKI5wpDwbtSvuodgMWREiKU4rFdfaYSyqty8ntc4SlUTZwtDY72sUA4" +
                "j6mKZlWUcDjdrXlme3j/7nPfMTRflRwZ3LjCpKk8STkuxSohHsKYBVagj7cRCay4XJdMvaJoGOey" +
                "Dpv0k6TLifPgLxbWnUtYG/nnURKf0VwQSRyr+d9l3nSQRttWjxFuU/B0C/uz2MpgU6jvbDn66im/" +
                "BYqqCwdM9b41zohOHRpWaxxfJj6L21OuP1WJBCCAp9I+AeSsGoXOyVyfibqglGe826Rs7iYlrPEo" +
                "Klli3/IbAIR/pHXo80f9ZRIUHrBk8nbeDqDGQcXU0eGRwA6fdKQMjEqQnPIGztbRk7HpZeKkTEmi" +
                "PVZyWBtJii8DE31fOibNRw3XNrOAxXhIfzXvv8g3vdN38LSidUbLpO47z6vtxaZhdMskeFcPPw7j" +
                "nHSMXRL0VB447+djQgICGB5t/Aqjf3mf2kVBpJABkjpvgOrayC9aPFOvAQfkA74PlY4stm/T1VsU" +
                "6VUM3mVep4PdzxB056AKjoW2Llx4gX7/TvEPiPzpvfL1UG77GpRRERfXKyBqUIcMyaqBkJJJuxD9" +
                "pdIBon+xaZoslqv11kBy8cFAavzqhExwyeKil8pZ1fvV4KLT4fvyCvH/aqsixOtX/gjve/3sDTEp" +
                "NeMd/ZuoUBlMexfXaimAhu6JUpJu9Hk0Xi8Uk255U0yj7Y5uc5HA4AMAzf58Ia/+N71JhL10fNrk" +
                "AghWaCou6DSbMTxA";
        System.out.println("-------------------------------");
        System.out.println(Tool.decrypt(encData,pubKey));

        System.out.println("-------------------------------");*/

        /*String msg = "hello world";
        String encodedMsg = Tool.encrypt(msg, priKey);
        System.out.println("encoded msg is :"+encodedMsg);
        System.out.println("decoded msg is :" + Tool.decrypt(encodedMsg, pubKey));*/

        Map<String,Object>txInfo = new LinkedHashMap<String,Object>();
        txInfo.put("AppSeqId","20160101101010123456");
        txInfo.put("LiqDate","20160105");
        txInfo.put("CertificateType","0");
        txInfo.put("CertificateNo","42900612345678910");
        txInfo.put("CardNo","622222222222222-鑷姩");
        txInfo.put("UsrName","--lnaln閲戣瘉123");
        txInfo.put("Mp","13412300000");
        txInfo.put("PgRecvUrl","http://www.baidu.com");
        txInfo.put("BgRecvUrl","http://www.baidu.com");
        txInfo.put("MerPriv", "");
        txInfo.put("ExtendInfo","");

        StringBuffer txInfoStr = new StringBuffer();
        StringBuffer signingStr = new StringBuffer();

        for(String key :txInfo.keySet()){
            txInfoStr.append("<").append(key).append(">")
                    .append(txInfo.get(key))
                    .append("</").append(key).append(">");
            signingStr.append(key.substring(0,1).toLowerCase()+key.substring(1)).append("=").append(txInfo.get(key)).append("&");
        }
        if(signingStr.length() > 0){
            signingStr.deleteCharAt(signingStr.length()-1);
        }
        String sign = Tool.sign(signingStr.toString(),token);

        StringBuffer xmlStr = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        xmlStr.append("<Request>")
                .append("<Version>").append("1.0.0").append("</Version>")
                .append("<AppId>").append("8888").append("</AppId>")
                .append("<TransType>").append("1011").append("</TransType>")
                .append("<ChannelId>").append("0120").append("</ChannelId>")
                .append("<BankId>").append("0120").append("</BankId>")
                .append("<TxInfo>").append(txInfoStr.toString()).append("</TxInfo>")
                .append("<Sign>").append(sign).append("</Sign>")
                .append("</Request>");

        //鍔犲瘑涔嬪墠
        System.out.println("data before encrypt is :\n"+xmlStr.toString());

        String encodedMsg = Tool.encrypt(xmlStr.toString(), priKey);

        encodedMsg = Tool.deleteLineBlank(encodedMsg);

        System.out.println("data encrypted is :\n"+encodedMsg);
        //瑙ｅ瘑涔嬪悗
        String decodeMsg = Tool.decrypt(encodedMsg, pubKey);

        System.out.println("data decrypted is :\n"+decodeMsg);

        System.out.println("verify result :\n"+decodeMsg.equals(xmlStr.toString()));

        String signature = decodeMsg.substring(decodeMsg.indexOf("<Sign>")+6,decodeMsg.indexOf("</Sign>"));

        System.out.println("verify result :\n"+Tool.verifySign(signingStr.toString(),signature,token) );





    }

    /**
     * 鍘绘帀鎹㈣鍥炶溅tab
     * @param str
     * @return
     */
    public static String deleteLineBlank(String str)
    {
        if(str != null && str.length() > 0){
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            return m.replaceAll("");
        }else{
            return null;
        }
    }



}
