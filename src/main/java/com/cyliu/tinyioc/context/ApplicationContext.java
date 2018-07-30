package com.cyliu.tinyioc.context;

public interface ApplicationContext {


    Object getBean(String beanName) throws Exception;
}
