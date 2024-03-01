package com.sun;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExample {

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        // 每隔5分钟执行一次任务
        executor.scheduleAtFixedRate(() -> {
            long now = System.currentTimeMillis();
            // 这里放置需要每隔5分钟执行的任务
            System.out.println("当前时间"+now+",任务执行中...");
        }, 0, 5, TimeUnit.SECONDS);
    }
}
