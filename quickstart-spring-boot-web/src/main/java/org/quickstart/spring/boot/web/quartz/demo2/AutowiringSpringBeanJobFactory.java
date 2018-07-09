package org.quickstart.spring.boot.web.quartz.demo2;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;
import org.springframework.stereotype.Component;

/**
 * Adds autowiring support to quartz jobs. Created by david on 2015-01-20.
 * 
 * @see https://gist.github.com/jelies/5085593
 */
@Component
public final class AutowiringSpringBeanJobFactory extends SpringBeanJobFactory implements ApplicationContextAware {

    // 这个对象Spring会帮我们自动注入进来,也属于Spring技术范畴.
    @Autowired
    private AutowireCapableBeanFactory capableBeanFactory;

    @Override
    public void setApplicationContext(final ApplicationContext context) {
        capableBeanFactory = context.getAutowireCapableBeanFactory();
    }

    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        // 调用父类的方法
        Object jobInstance = super.createJobInstance(bundle);
        // 进行注入,这属于Spring的技术,不清楚的可以查看Spring的API.
        capableBeanFactory.autowireBean(jobInstance);
        return jobInstance;
    }

}
