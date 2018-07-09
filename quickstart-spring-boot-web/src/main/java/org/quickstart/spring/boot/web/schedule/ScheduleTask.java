/**
 * 项目名称：quickstart-spring-boot 
 * 文件名：ScheduleTask.java
 * 版本信息：
 * 日期：2017年7月5日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.spring.boot.web.schedule;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.FastDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * ScheduleTask
 * 
 * @author：yangzl@asiainfo.com
 * @2017年7月5日 上午11:09:46
 * @version 1.0
 */
@Component
public class ScheduleTask {

    private static final Logger logger = LoggerFactory.getLogger(ScheduleTask.class);

    public final static long SECOND = 1 * 1000;
    FastDateFormat fdf = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");

    @Scheduled(fixedDelay = SECOND * 15)
    public void fixedDelayJob() throws InterruptedException {
        logger.debug("[FixedDelayJob Execute]" + fdf.format(new Date()));
        TimeUnit.SECONDS.sleep(5);
    }

    @Scheduled(fixedRate = SECOND * 10)
    public void fixedRateJob() throws InterruptedException {
        logger.debug("[FixedRateJob Execute]" + fdf.format(new Date()));
        TimeUnit.SECONDS.sleep(5);
    }

    @Scheduled(cron = "0/20 * *  * * ? ") // 每5秒执行一次
    public void cronJob() {
        logger.debug("[CronJob Execute]" + fdf.format(new Date()));
    }

}
