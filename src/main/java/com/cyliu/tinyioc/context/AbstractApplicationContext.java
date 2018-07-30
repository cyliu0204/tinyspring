package com.cyliu.tinyioc.context;

import com.cyliu.tinyioc.beans.factory.AbstractBeanFactory;
import com.cyliu.tinyioc.beans.factory.BeanFactory;

public abstract class AbstractApplicationContext implements ApplicationContext{
    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext (AbstractBeanFactory beanFactory){
        this.beanFactory = beanFactory;
    }

    protected AbstractBeanFactory getBeanFactory() {
        return beanFactory;
    }

    @Override
    public Object getBean(String beanName) throws Exception {
        return  beanFactory.getBean(beanName);
    }
}
