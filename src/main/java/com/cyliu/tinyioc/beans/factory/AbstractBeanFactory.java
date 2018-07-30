package com.cyliu.tinyioc.beans.factory;


import com.cyliu.tinyioc.beans.BeanDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractBeanFactory implements BeanFactory {

    private ConcurrentHashMap<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    private List<String> beanNames = new ArrayList<>();

    @Override
    public Object getBean(String className) throws Exception{
        BeanDefinition beanDefinition = beanDefinitionMap.get(className);
        if (beanDefinition == null) {
            throw new IllegalArgumentException("No bean named " + className + " is defined");
        }
        if (beanDefinition.getBean() == null){
              doCreateBean(beanDefinition);
        }
        return  beanDefinition.getBean();
    }

    @Override
    public void registerBeanDefinition(String className,BeanDefinition beanDefinition) throws Exception{
        beanDefinitionMap.put(className,beanDefinition);
        beanNames.add(className);
    }

    public void initiateSingletons() throws Exception {
        for (String className : beanNames){
            getBean(className);
        }
    }

    /**
     * 放到子类实例化 模板模式
     * @param beanDefinition
     * @return 实例化bean
     */

    public abstract Object doCreateBean  (BeanDefinition beanDefinition) throws Exception;
}
