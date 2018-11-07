package com.FileOP;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2016/12/21.
 */
public class FileIOTest {
    public static void main(String[] args) throws IOException{
        String path="C:\\Users\\Administrator\\Desktop\\chinapay\\testData";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        String filePath = path + File.separator + "tesasdf.txt";
        File filex = new File(filePath);

        if (filex.exists()) {
            filex.delete();
        }
        filex.createNewFile();
        FileOutputStream fops = new FileOutputStream(filex);
        fops.write(("adsfasdfsaf").getBytes("utf-8"));

        fops.flush();
        fops.close();

    }
}
