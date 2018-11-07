package cn.endcy.fileutils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by cxx on 2017/6/29.
 */
public class FileUtils {

    /**
     * 判断路径是否存在 不存在则创建
     *
     * @param path
     */
    public static void mkDir(String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    /**
     * 获取文件夹下面所有文件名
     *
     * @param path
     * @return 文件名List
     */
    public static List<String> getFilesByFolder(String path) {
        List<String> fileList = new ArrayList<String>();
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                return fileList;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        getFilesByFolder(file2.getAbsolutePath());
                    } else {
                        fileList.add(file2.getAbsolutePath());
                    }
                }
            }
        } else {
            return fileList;
        }
        return fileList;
    }

    /**
     * 根据保存路径和保存文件名压缩指定路径下所有文件
     *
     * @param savePath     保存路径
     * @param saveFileName 保存文件名
     * @param toZipPath    待压缩文件路径
     * @throws Exception
     */
    public static void zipFile(String savePath, String saveFileName, String toZipPath) throws Exception {
        mkDir(savePath);
        List<String> files = getFilesByFolder(toZipPath);
        byte[] buf = new byte[1024];
        String outFilename = saveFileName + ".zip";
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(savePath + File.separator + outFilename));
        for (String file : files) {
            FileInputStream in = new FileInputStream(file);
            out.putNextEntry(new ZipEntry(saveFileName));
            int len = 0;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            out.closeEntry();
            in.close();
        }
        out.close();
    }

    /**
     * 以UTF-8编码将字符串写入指定路径和名称的文件
     *
     * @param path     指定保存路径
     * @param fileName 指定保存文件名
     * @param content  保存的内容
     * @return  写入文件的完整路径
     * @throws IOException
     */
    public static String writeFile(String path, String fileName, String content) throws IOException {
        return writeFile(path, fileName, content, "UTF-8");
    }

    /**
     * 以指定编码将字符串写入指定路径和名称的文件
     *
     * @param path     指定保存路径
     * @param fileName 指定保存文件名
     * @param content  保存的内容
     * @param charset  注定编码
     * @return  写入文件的完整路径
     * @throws IOException
     */
    public static String writeFile(String path, String fileName, String content, String charset) throws IOException {
        mkDir(path);
        String filePath = path + File.separator + fileName;
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        FileOutputStream fops = new FileOutputStream(file);
        fops.write((content).getBytes(charset));
        fops.flush();
        fops.close();
        return filePath;
    }

    /**
     * 读取文件内容为字符串
     *
     * @param filePath 文件完整路径
     * @return  文件内容
     * @throws IOException
     */
    public static String readFile(String filePath) throws IOException {
        File file = new java.io.File(filePath);
        FileInputStream fin = new FileInputStream(file);
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        while (true) {
            int read = fin.read();
            if (read == -1) {
                break;
            } else {
                bs.write(read);
            }
        }
        String content = new String(bs.toByteArray(), "UTF-8");
        fin.close();
        bs.close();
        return content;
    }

    /**
     * 读取文件内容为字节数组
     *
     * @param filePath 文件完整路径
     * @return  文件字节数组
     * @throws IOException
     */
    public static byte[] getFileBytes(String filePath) throws IOException {
        File file = new java.io.File(filePath);
        FileInputStream fin = new FileInputStream(file);
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        while (true) {
            int read = fin.read();
            if (read == -1) {
                break;
            } else {
                bs.write(read);
            }
        }
        byte[] bytesArr = bs.toByteArray();
        fin.close();
        bs.close();
        return bytesArr;
    }
}
