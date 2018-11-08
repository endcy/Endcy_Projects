package com.getwebdata.getinfo.core.impl;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.getwebdata.getinfo.config.Constant;
import com.getwebdata.getinfo.config.Counter;
import com.getwebdata.getinfo.config.ThreadLocalUtil;
import com.getwebdata.getinfo.core.CrawlerThread;
import com.getwebdata.getinfo.utils.HtmlUtil;
import com.getwebdata.getinfo.utils.ImgSaveUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ImgDownload extends CrawlerThread {

    public ImgDownload(String url, Enum type) {
        super(url, type);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "***** START");
        final WebClient webClient = new WebClient(BrowserVersion.CHROME);
        String tempUrl = null;
        do {
            try {
                tempUrl = ((ArrayBlockingQueue<String>) getT()).poll(100, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                break;
            }
            System.out.println("-------------- url contains start:" + tempUrl);
            if (tempUrl == null || "".equals(tempUrl)) break;
            HtmlPage page = HtmlUtil.getPage(webClient, tempUrl);
            if (page == null) {
                //todo taskVO-List and counter
                webClient.close();
                return;
            }
            webClient.waitForBackgroundJavaScript(Constant.JSEXC_TIME); //javascript执行x秒
            String pageXml = page.asXml();
            Document document = Jsoup.parse(pageXml, "http://online.sccnn.com");
            List<Element> infoListEle = null;
            try {
                infoListEle = document.getElementsByTag("img");
            } catch (Exception e) {
                e.printStackTrace();
                return;
            } finally {
                webClient.close();
            }
            for (Element element : infoListEle) {
                String imgUrl = element.absUrl("src");
                if (imgUrl != null && imgUrl.length() > 0)
                    saveInfo(imgUrl);
            }
        } while (tempUrl != null);
        System.out.println(Thread.currentThread().getName() + "***** END");
        System.out.println("***************线程：" + Thread.currentThread().getName() + " 获取图片数量" + ThreadLocalUtil.threadLocal.get().size() + "***************");
        Thread.currentThread().interrupt();
        Counter.endThreadCounter.countDown();   //完成线程计数器减1
    }

    @Override
    public void saveInfo(Object imgUrl) {
        String img = String.valueOf(imgUrl);
        boolean isTarget = false;
        for (String str : Constant.IMG_EXP_CONTSTR) {
            if (img.contains(str)) {
                System.out.println(img);
                Counter.getInstance().addIgnoreCounter();
                return;
            }
            isTarget = true;
        }
        if (isTarget) {
            Counter.getInstance().addTargetCounter();
            img = img.replaceAll("\\.\\./", "");
            System.out.println(Thread.currentThread() + ":get Target IMG----" + img);
            ThreadLocalUtil.threadLocal.get().add(img);
//            ImgSaveUtil.saveImage(Constant.IMG_SAVING_PATH, img);
//            try {
//                Thread.sleep(Constant.DOWDLOAD_AFTER_MILLSLEEP);
//            } catch (InterruptedException e) {
//            }
        }
    }

}
