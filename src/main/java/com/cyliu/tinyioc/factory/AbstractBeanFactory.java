package com.cyliu.tinyioc.factory;


import com.cyliu.tinyioc.BeanDefinition;

import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractBeanFactory implements BeanFactory {

    private ConcurrentHashMap<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    @Override
    public Object getBean(String className){
        return  beanDefinitionMap.get(className).getBean();
    }

    @Override
    public void registerBeanDefinition(String className,BeanDefinition beanDefinition) throws Exception{
        Object bean = doCreateBean(beanDefinition);
        beanDefinition.setBean(bean);
        beanDefinitionMap.put(className,beanDefinition);
    }

    /**
     * 放到子类实例化 策略模式
     * @param beanDefinition
     * @return 实例化bean
     */

    public abstract Object doCreateBean  (BeanDefinition beanDefinition) throws Exception;
}
