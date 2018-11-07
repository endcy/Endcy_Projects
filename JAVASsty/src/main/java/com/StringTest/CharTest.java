package com.StringTest;

/**
 * Created by cxx on 2017/2/20.
 */
public class CharTest {
    public static void main(String[] args) {
        String ubankNo = "00022221";
        String remitLocation = "" ;
        if(ubankNo.length() >= 7){
                if("0121211".substring(3,7).equals("022111123".substring(3,7)))
                    remitLocation = "0";
                else
                    remitLocation = "1";
        }
        System.out.println(remitLocation);
        System.out.println("0121211".substring(3,7));
        boolean flag = false;
        if(flag = true){
            System.out.println("true");
        }
    }
}
