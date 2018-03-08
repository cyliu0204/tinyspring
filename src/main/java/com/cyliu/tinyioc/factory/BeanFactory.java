package com.cyliu.tinyioc.factory;

import com.cyliu.tinyioc.BeanDefinition;


public interface BeanFactory {

    Object getBean(String className);

    void registerBeanDefinition(String className, BeanDefinition beanDefinition) throws Exception;
    

}
