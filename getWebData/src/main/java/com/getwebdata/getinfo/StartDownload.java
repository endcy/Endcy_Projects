package com.getwebdata.getinfo;


import com.getwebdata.getinfo.config.Counter;
import com.getwebdata.getinfo.core.CrawlerThreadPoolFactory;
import com.getwebdata.getinfo.utils.InfoType;
import com.getwebdata.getinfo.vo.TaskVO;
import org.apache.commons.logging.LogFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class StartDownload {
    public static void main(String[] args) {
        LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
        java.util.logging.Logger.getLogger("org.apache.http.client.HttpClient").setLevel(Level.OFF);
        java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF);
        String url = "http://online.sccnn.com/html/cion/index-";
        String lastUrl = ".htm";
        TaskVO taskVO = new TaskVO();
        taskVO.setInitUrl(url, lastUrl);
        ArrayBlockingQueue<String> urls = new ArrayBlockingQueue<>(111);
        for (int i = 1; i <= 111; i++) {
            urls.offer(url + i + lastUrl);
        }
        taskVO.setUrls(urls);
        ExecutorService service = CrawlerThreadPoolFactory.getThreadPool(InfoType.IMG, taskVO);
        try {
            Counter.endThreadCounter.await();
            System.out.println("All Threads are Ending !");
            service.shutdown();
            service.awaitTermination(3*1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            service.shutdownNow();
        }
        if (service.isShutdown()) {
            System.out.println("获取到图片和忽略图片数目分别为：" + Counter.getInstance().getTargetCounter() + "--" + Counter.getInstance().getIgnoreCounter());
        }else {
            System.out.println("线程执行状态异常，强制停止继续运行！");
            service.shutdownNow();
        }
    }
}
