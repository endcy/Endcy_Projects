package cn.endcy.fileutils;

import java.io.*;
import java.util.Properties;

/**
 * Created by cxx on 2017/5/13.
 */
public class ReadProperties {
    public static String filepath = null;

    static {
        File directory = new File("");
        filepath = directory.getAbsolutePath();  //生成项目(非module）相对路径 项目中与src或生成的jar包目录同级别
    }

    /**
     * 获取properties完整路径下该文件所有配置
     *
     * @param relFilePath
     * @return
     */
    public static Properties getConfigFile(String relFilePath) throws Exception{
        Properties config = new Properties();
        InputStream is = null;
        String path = filepath + relFilePath;
        if(!new File(path).isFile()){
            throw new FileNotFoundException("该文件不存在：" + filepath + relFilePath);
//            path = "E:\\jfiles\\FileRW\\src\\main\\resources\\config.properties";
        }
        try {
            is = new FileInputStream(new File(path));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            config.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return config;
    }

    public static void main(String[] args) throws Exception {
        String relFilePath = "/main/resources/config.properties";
        Properties config = getConfigFile(relFilePath);
        if(config == null){
            return;
        }
            String isOpen = config.getProperty("isOpen");
        System.out.println(isOpen.equals("0") ? "not open" : config.getProperty("MaxNum"));
    }
}
