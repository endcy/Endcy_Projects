package com.getwebdata.getinfo.core;

import com.getwebdata.getinfo.config.Constant;
import com.getwebdata.getinfo.core.impl.ImgDownload;
import com.getwebdata.getinfo.utils.InfoType;
import com.getwebdata.getinfo.vo.TaskVO;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CrawlerThreadPoolFactory {
    public static ExecutorService getThreadPool(InfoType type, TaskVO taskVO) {
        ExecutorService service = Executors.newFixedThreadPool(Constant.THREAD_NUM);

        switch (type) {
            case IMG: {
                for (int i = 1; i <= Constant.THREAD_NUM; i++) {
                    if (taskVO.getUrls() != null && taskVO.getUrls().size() >= i) {

                        CrawlerThread thread = new ImgDownload(taskVO.getInitUrl() + taskVO.getLastUrl(), type);
                        thread.setT(taskVO.getUrls());
                        service.execute(thread);

                    }
                }
            }
            case FILE: {
                break;
            }
            case WORLD: {
                break;
            }
            case LIST: {
                break;
            }
            case ELEMENT: {
                break;
            }
            default:
                return null;
        }
        return service;
    }


    public static void main(String[] args) {
        ImgDownload imgDownload = new ImgDownload("", InfoType.IMG);
    }
}
