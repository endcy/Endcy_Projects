package com.multThread.fourThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2018/4/16.
 * Version      : 1.0
 * ***************************************************************************
 */
public class MainTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Future<Integer>> list = new ArrayList<Future<Integer>>();
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            int num = (int) (Math.random() * 100);
            list.add(service.submit(new CallableThread(num)));
        }
        for (Future<Integer> future : list) {
            System.out.println(future.get());
        }
        service.shutdown();
    }
}
