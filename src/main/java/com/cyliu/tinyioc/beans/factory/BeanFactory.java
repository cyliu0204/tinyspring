package com.cyliu.tinyioc.beans.factory;

import com.cyliu.tinyioc.beans.BeanDefinition;


public interface BeanFactory {

    Object getBean(String className) throws Exception;

    void registerBeanDefinition(String className, BeanDefinition beanDefinition) throws Exception;
    

}
