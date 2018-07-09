package org.quickstart.spring.boot.web.quartz.demo2;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by david on 2015-01-20.
 */
public class SampleJob implements Job {

    @Autowired
    private SampleService service;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        service.hello();
    }
}
