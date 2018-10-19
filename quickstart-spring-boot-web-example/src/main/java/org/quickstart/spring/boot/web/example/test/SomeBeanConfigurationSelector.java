/**
 * 项目名称：quickstart-spring-boot-web-example 
 * 文件名：SomeBeanConfigurationSelector.java
 * 版本信息：
 * 日期：2018年9月22日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.spring.boot.web.example.test;

/**
 * SomeBeanConfigurationSelector 
 *  
 * @author：yangzl@asiainfo.com
 * @2018年9月22日 下午11:26:29 
 * @since 1.0
 */
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

public class SomeBeanConfigurationSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        AnnotationAttributes attributes = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(EnableSomeBeansSelector.class.getName(), false));
        String criteria = attributes.getString("criteria");
        if (criteria.equals("default")) {
            return new String[] {"enableannot.selector.SomeBeanConfigurationDefault"};
        } else {
            return new String[] {"enableannot.selector.SomeBeanConfigurationType1"};
        }
    }
}
