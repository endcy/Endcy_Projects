package com.NIO;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 * ***************************************************************************
 * Description  : 获取所有特定格式文件并存保存于容器
 * Author       : cxx
 * Creation date: 2018/5/25.
 * Version      : 1.0
 * ***************************************************************************
 */
public class FileTravers {

    public static void main(String[] args) throws Exception {
//        String rootPath = "E:\\szkingdom\\KUPP\\trunk\\KDGS\\src\\webapps\\KDGS\\kdgs-admin";
        String rootPath = "E:\\szkingdom\\KUPP\\trunk\\KDGS\\src";
//        String[] format = new String[]{".java", ".xml", ".sql", ".pom", ".properties", ".cfg", ".bat", ".html", ".js", ".css"};
//        String[] format = new String[]{".java", ".xml", ".sql", ".properties", ".cfg", ".bat"};
        String[] format = new String[]{".java"};
        String[] excPath = new String[]{"\\.idea\\", "\\target\\", "\\out\\", "\\src\\test\\", "\\webapp\\plugins\\", "\\webapp\\ui","\\kdgs-shhq-quickfix\\"};
        List<String> list = getFileTree(rootPath);
        list = getTargetFiles(list, excPath, format);
        for (String fileName : list)
            System.out.println(fileName);
        System.out.println("\r\n" + "文件总数：" + list.size());
        System.out.println("当前模块路径：" + rootPath);
        String targetTxt = rootPath + File.separator + "kdgs-code.txt";
        writeProjectInTxt(list, targetTxt);
    }

    public static List getFileTree(String path) throws Exception {
        final List<String> list = new ArrayList<>();
        Path initPath = Paths.get(path);
        Files.walkFileTree(initPath, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                list.add(file.toString());
                return FileVisitResult.CONTINUE;
            }
        });
        return list;
    }

    public static List getTargetFiles(List<String> list, String[] excPath, String[] formats) {
        List<String> targetList = new ArrayList<>();
        boolean isExcPathFile;
        //排除无效文件夹
        for (String test : list) {
            isExcPathFile = false;
            for (String exc : excPath) {
                if (test.contains(exc))
                    isExcPathFile = true;
            }
            if (isExcPathFile)
                continue;
            //获取规则内的类型文件
            for (String form : formats) {
                if (test.lastIndexOf(form) > 1) {
                    targetList.add(test);
                }
            }
        }
        return targetList;
    }

    public static void writeProjectInTxt(List<String> list, String targetTxt) {
        File file = new File(targetTxt);
        if (!file.exists())
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        for (String fileName : list) {
//            String encoder = "GB2312";
//            try {
//                encoder = getFileCharset(fileName);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
            StringBuffer sb = new StringBuffer("");
            //读文件
            try {
                FileReader reader = new FileReader(fileName);
                BufferedReader br = new BufferedReader(reader);
                String str;
                while ((str = br.readLine()) != null) {
                    //排除换行符
                    if (str.equals("")) ;
                    else
                        sb.append(str).append("\r\n");
                }
                br.close();
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            //写文件,最后追加空行  不加
            String content = sb.toString();
            BufferedWriter out = null;
            try {
                out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
//                content = new String((content + "\r\n").getBytes(encoder),"UTF-8");
                content = new String(content);
                out.write(content);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * <div>
     * 利用第三方开源包cpdetector获取文件编码格式.<br/>
     * --1、cpDetector内置了一些常用的探测实现类,这些探测实现类的实例可以通过add方法加进来,
     *   如:ParsingDetector、 JChardetFacade、ASCIIDetector、UnicodeDetector. <br/>
     * --2、detector按照“谁最先返回非空的探测结果,就以该结果为准”的原则. <br/>
     * --3、cpDetector是基于统计学原理的,不保证完全正确.<br/>
     * </div>
     * @param filePath
     * @return 返回文件编码类型：GBK、UTF-8、UTF-16BE、ISO_8859_1
     * @throws Exception
     */
//    public static String getFileCharset(String filePath) throws Exception {
//        CodepageDetectorProxy detector = CodepageDetectorProxy.getInstance();
//		/*ParsingDetector可用于检查HTML、XML等文件或字符流的编码,
//		 * 构造方法中的参数用于指示是否显示探测过程的详细信息，为false不显示。
//	    */
//        detector.add(new ParsingDetector(false));
//		/*JChardetFacade封装了由Mozilla组织提供的JChardet，它可以完成大多数文件的编码测定。
//		 * 所以，一般有了这个探测器就可满足大多数项目的要求，如果你还不放心，可以再多加几个探测器，
//		 * 比如下面的ASCIIDetector、UnicodeDetector等。
//        */
//        detector.add(JChardetFacade.getInstance());
//        detector.add(ASCIIDetector.getInstance());
//        detector.add(UnicodeDetector.getInstance());
//        Charset charset = null;
//        File file = new File(filePath);
//        try {
//            charset = detector.detectCodepage(file.toURI().toURL());
////            InputStream is = new BufferedInputStream(new FileInputStream(filePath));
////            charset = detector.detectCodepage(is, 8);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw e;
//        }
//
//        String charsetName = "GBK";
//        if (charset != null) {
//            if (charset.name().equals("US-ASCII")) {
//                charsetName = "ISO_8859_1";
//            } else if (charset.name().startsWith("UTF")) {
//                charsetName = charset.name();// 例如:UTF-8,UTF-16BE.
//            }
//        }
//        return charsetName;
//    }

}
