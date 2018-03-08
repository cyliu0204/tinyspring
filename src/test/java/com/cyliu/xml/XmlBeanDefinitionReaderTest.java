package com.cyliu.xml;

import com.cyliu.AppTest;
import com.cyliu.tinyioc.BeanDefinition;
import com.cyliu.tinyioc.factory.AutowireCapableBeanFactory;
import com.cyliu.tinyioc.factory.BeanFactory;
import com.cyliu.tinyioc.io.Resource;
import com.cyliu.tinyioc.io.ResourceLoader;
import com.cyliu.tinyioc.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class XmlBeanDefinitionReaderTest {
    @Test
    public void test() throws Exception {
        // 1.读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinition("tinyioc.xml");

        // 2.初始化BeanFactory并注册bean
        BeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        // 3.获取bean
        AppTest helloWorldService = (AppTest) beanFactory.getBean("AppTest");
        helloWorldService.sayHi();

    }
}
