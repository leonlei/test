package com.leon.task;

import com.leon.service.TestService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator.
 * User: Leon
 * 2016/2/2
 */
@Component
public class TimeTask {
    private static final Logger logger = Logger.getLogger(TimeTask.class);

    @Autowired
    private TestService testService;

    @Scheduled(cron = "*/1 * * * * ?")
    public void updateIncome() {
        logger.info("定时任务：开始****");
        logger.info("定时任务：完成****");
    }
}
