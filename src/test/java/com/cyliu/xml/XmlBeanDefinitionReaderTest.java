package com.cyliu.xml;

import com.cyliu.AppTest;
import com.cyliu.tinyioc.beans.BeanDefinition;
import com.cyliu.tinyioc.beans.factory.AbstractBeanFactory;
import com.cyliu.tinyioc.beans.factory.AutowireCapableBeanFactory;
import com.cyliu.tinyioc.beans.io.ResourceLoader;
import com.cyliu.tinyioc.beans.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

public class XmlBeanDefinitionReaderTest {
    @Test
    public void test() throws Exception {
        // 1.读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinition("tinyioc.xml");

        // 2.初始化BeanFactory并注册bean
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
        beanFactory.initiateSingletons();
        // 3.获取bean
        AppTest helloWorldService = (AppTest) beanFactory.getBean("appTest");
        helloWorldService.sayHi();

    }
}
