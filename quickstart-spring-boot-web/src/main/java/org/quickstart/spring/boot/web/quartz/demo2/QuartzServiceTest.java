/**
 * 项目名称：quickstart-spring-boot 
 * 文件名：QuartzEventServiceImpl.java
 * 版本信息：
 * 日期：2017年8月5日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.spring.boot.web.quartz.demo2;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

/**
 * QuartzEventServiceImpl
 * 
 * @author：yangzl@asiainfo.com
 * @2017年8月5日 下午4:58:40
 * @version 2.0
 */
@Service
public class QuartzServiceTest implements CommandLineRunner {

    private static final String JOB_GROUP = "event_job_group";
    private static final String TRIGGER_GROUP = "event_trigger_group";

    @Autowired
    private Scheduler scheduler;

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
     */
    @Override
    public void run(String... args) throws Exception {

        JobDetail jobDetail = JobBuilder.newJob(SampleJob.class).withIdentity("job1", "group1").build();
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, cronTrigger);

    }

}
