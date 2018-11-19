package com.TT.demo.scheduleTask.fixRateSchedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by 苏文广 on 2018/11/19
 * 使用cron表达式创建定时任务
 */
@Component
public class FixRateScheduleTest {
    private int count =0;

    @Scheduled(fixedRate = 5000)
    private void process(){
        count++;
        System.err.println("这是一个每个5秒执行的定时任务！这是第"+count+"次执行");

    }
}
