package com.reflect.bean;

import com.constants.Checker;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cxx on 2016/8/31.
 */
public class CheckBaseBean {

    public void toBean(String recMsg) throws Exception{
        //将msg转为键值数组
        String[] msgField = recMsg.split(Checker.Split);
        Map fvalue=new HashMap();   //小写存key
        for(int i=0;i<msgField.length;i++){
            String temp=msgField[i];
//            String key=temp.substring(0,1).toUpperCase()+temp.substring(1,temp.indexOf("="));
            String key=temp.substring(0,temp.indexOf("=")).toLowerCase();
            String value=temp.substring(temp.indexOf("=")+1);
            fvalue.put(key,value);
        }
        Class clazz=this.getClass();
        Field[] fields= clazz.getDeclaredFields();
        for(Field field:fields){
            if(field !=null){
                String paraName=field.getName();
                String methodName="set"+paraName.substring(0,1).toUpperCase()+paraName.substring(1);
                try{
                    Method setMethod = clazz.getMethod(methodName,new Class[]{String.class});
                    String value=fvalue.get(paraName.toLowerCase())==null?"":fvalue.get(paraName.toLowerCase()).toString();
                    setMethod.invoke(this,value);
                    System.out.println(paraName+"="+value);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

}
