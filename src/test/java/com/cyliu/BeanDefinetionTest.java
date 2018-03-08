package com.cyliu;

import com.cyliu.tinyioc.factory.AutowireCapableBeanFactory;
import com.cyliu.tinyioc.BeanDefinition;
import com.cyliu.tinyioc.factory.BeanFactory;

public class BeanDefinetionTest {



    public static void main(String[] args) throws Exception {
        BeanFactory beanFactory = new AutowireCapableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.cyliu.AppTest");
        beanFactory.registerBeanDefinition("appTest",beanDefinition);

        AppTest appTest = (AppTest) beanFactory.getBean("appTest");
        appTest.sayHi();
    }
}
