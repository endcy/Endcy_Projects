package com.multThread;

import java.util.ArrayList;
import java.util.List;

/**
 * 任务分发器
 * <p/>
 * <a href="http://home.51cto.com/index.php?s=/space/1269642" target="_blank">@author</a> Administrator
 */
public class TaskManager {
    //设置要启动的最大工作线程数量
    public static int threadCount = 5;

    public static void main(String[] args) {
//初始化要执行的任务列表
        List<Task> taskList = new ArrayList<Task>();
        for (int i = 0; i < 50; i++) {
            taskList.add(new Task(i));
        }
//设置要启动的工作线程数量
//int threadCount = 5;
        List[] taskListPerThread = managerTasks(taskList, TaskManager.threadCount);

        System.out.println("实际要启动的工作线程数：" + taskListPerThread.length);

        for (int i = 0; i < taskListPerThread.length; i++) {
//实际开发时是否需要传入短信发送连接对象
            Thread workThread = new WorkThread(taskListPerThread[i], i);
            workThread.start();
        }
    }

    /**
     * 把 List 中的任务分配给每个线程，先平均分配，剩于的依次附加给前面的线程 返回的数组有多少个元素 (List) 就表明将启动多少个工作线程
     *
     * @param taskList    待分派的任务列表
     * @param threadCount 线程数
     *                    <a href="http://home.51cto.com/index.php?s=/space/34010" target="_blank">@return</a> 列表的数组，每个元素中存有该线程要执行的任务列表
     */
    public static List[] managerTasks(List<Task> taskList, int threadCount) {
//每个线程至少要执行的任务数,假如不为零则表示每个线程都会分配到任务
        int minTaskCount = taskList.size() / threadCount;
//平均分配后还剩下的任务数，不为零则还有任务依个附加到前面的线程中
        int remainTaskCount = taskList.size() % threadCount;
//实际要启动的线程数,如果工作线程比任务还多
//自然只需要启动与任务相同个数的工作线程，一对一的执行
//毕竟不打算实现了线程池，所以用不着预先初始化好休眠的线程
        int actualThreadCount = minTaskCount > 0 ? threadCount : remainTaskCount;
//要启动的线程数组，以及每个线程要执行的任务列表
        List<Task>[] taskListPerThread = new List[actualThreadCount];
        int taskIndex = 0;
//平均分配后多余任务，每附加给一个线程后的剩余数，重新声明与 remainTaskCount
//相同的变量，不然会在执行中改变 remainTaskCount 原有值，产生麻烦
        int remainIndces = remainTaskCount;
        for (int i = 0; i < taskListPerThread.length; i++) {
            taskListPerThread[i] = new ArrayList<Task>();
//如果大于零，线程要分配到基本的任务
            if (minTaskCount > 0) {
                for (int j = taskIndex; j < minTaskCount + taskIndex; j++) {
                    taskListPerThread[i].add(taskList.get(j));
                }
                taskIndex += minTaskCount;
            }
//假如还有剩下的，则补一个到这个线程中
            if (remainIndces > 0) {
                taskListPerThread[i].add(taskList.get(taskIndex++));
                remainIndces--;
            }
        }
//打印任务的分配情况
        for (int i = 0; i < taskListPerThread.length; i++) {
            System.out.println("线程 " + i + " 的任务数：" + taskListPerThread[i].size() + " 区间[" + taskListPerThread[i].get(0).getTaskId() + "," + taskListPerThread[i].get(taskListPerThread[i].size() - 1).getTaskId() + "]");
        }
        return taskListPerThread;
    }
} 
