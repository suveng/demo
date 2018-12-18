package com.tt.demo.schedule.cron;

import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by 苏文广 on 2018/11/19
 * 使用cron表达式创建定时任务
 * @author 苏文广
 */
//@Component
public class CronScheduleTest {
    private int count =0;

    @Scheduled(cron = "*/4 * * * * ?")
    private void process(){
        count++;
        System.err.println("这是一个每个4秒执行的定时任务！这是第"+count+"次执行");

    }
}
