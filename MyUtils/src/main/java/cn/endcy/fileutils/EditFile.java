package cn.endcy.fileutils;

import java.io.*;

/**
 * Created by cxx on 2017/7/6.
 */
public class EditFile {

    /**
     * 修改文本文件被的指定内容
     *
     * @param file        文件完整路径
     * @param content     文中待替换字符串
     * @param extContent  替换未目标字符换
     * @param isChangeAll 是否全部替换
     * @throws Exception
     */
    public static void replaceStrInFile(String file, String content, String extContent, boolean isChangeAll) {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader(file);
            fw = new FileWriter(file + "x");
        } catch (Exception e) {
            e.printStackTrace();
        }
        BufferedReader in = new BufferedReader(fr);
        PrintWriter pw = new PrintWriter(fw);
        String temp;
        boolean isChanged = false;
        int index = 0;
        try {
            while ((temp = in.readLine()) != null) {
                if (temp.contains(content)) {
                    System.out.println("*********找到匹配串*********");
                }
                if (temp.contains(content) && !isChangeAll && index == 0) {
                    temp = temp.replace(content, extContent);
                    index++;
                    isChanged = true;
                }
                if (temp.contains(content) && isChangeAll) {
                    temp = temp.replaceAll(content, extContent);
                    isChanged = true;
                }
                pw.println(temp);
                pw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                pw.close();
                fw.close();
                in.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("临时文件写操作完成。");
        if (isChanged) {    //如源文件匹配并替换有变化后则重写文件
            FileReader frx = null;
            FileWriter fwx = null;
            try {
                frx = new FileReader(file + "x");
                fwx = new FileWriter(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
            BufferedReader inx = new BufferedReader(frx);
            PrintWriter pwx = new PrintWriter(fwx);
            String tempx;
            try {
                while ((tempx = inx.readLine()) != null) {
                    pwx.println(tempx);
                    pwx.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    pwx.close();
                    fwx.close();
                    inx.close();
                    frx.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        new File(file + "x").delete();
        System.out.println("写文件完成，删除临时文件。");
    }

    /**
     * 统计文件内目标字符串出现次数
     *
     * @param file   文件完整路径
     * @param target 目标字符串
     * @return
     * @throws Exception
     */
    public static int getStrShowTimes(String file, String target) {
        int count = 0;
        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader in = new BufferedReader(fr);
        String temp;
        try {
            while ((temp = in.readLine()) != null) {
                while (temp.indexOf(target) != -1) {
                    count++;
                    temp = temp.substring(temp.indexOf(target) + target.length());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            in.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 追加写文件，文件不存在则新增文件
     *
     * @param path
     * @param fileName
     * @param content
     * @param charset
     * @return
     */
    public static boolean writeExistOrNewFile(String path, String fileName, String content, String charset) {
        File fileTemp = new File(path);
        if (!fileTemp.exists())
            try {
                fileTemp.mkdirs();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        String filePath = path + File.separator + fileName;
        File file = new File(filePath);
        if (!file.exists())
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
            String cont = new String((content + "\r\n").getBytes(charset), charset);
            out.write(cont);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        try {
            System.out.println(getStrShowTimes("C:\\Users\\Administrator\\Desktop\\new 1.txt", "######"));
            replaceStrInFile("C:\\Users\\Administrator\\Desktop\\new 1.txt", "######", "替换完成", true);
            System.out.println(getStrShowTimes("C:\\Users\\Administrator\\Desktop\\new 1.txt", "######"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
