package com.getwebdata.getinfo.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ImgSaveUtil {
    public static void saveImage(String filePath, String imageUrl) {
        String fileName = imageUrl.substring(imageUrl.lastIndexOf("/"));
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileOutputStream out = null;
        InputStream is = null;
        BufferedInputStream bis = null;
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            is = connection.getInputStream();
            bis = new BufferedInputStream(is);
            File imgFile = new File(filePath + fileName);
            out = new FileOutputStream(imgFile);
            byte[] buf = new byte[1024];
            int i = 0;
            while ((i = bis.read(buf)) != -1)
                out.write(buf, 0, i);
            out.flush();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
