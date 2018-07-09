package org.quickstart.spring.boot.web.quartz.demo3;

import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * Created by david on 2015-01-20.
 */
public class SampleJob3 extends QuartzJobBean {

    @Autowired
    private SampleService service;

    @Override
    public void executeInternal(JobExecutionContext jobExecutionContext) {
        // Do injection with spring
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        service.hello();
    }
}
