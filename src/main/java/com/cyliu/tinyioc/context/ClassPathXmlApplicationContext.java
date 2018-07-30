package com.cyliu.tinyioc.context;

import com.cyliu.tinyioc.beans.BeanDefinition;
import com.cyliu.tinyioc.beans.factory.AbstractBeanFactory;
import com.cyliu.tinyioc.beans.factory.AutowireCapableBeanFactory;
import com.cyliu.tinyioc.beans.io.ResourceLoader;
import com.cyliu.tinyioc.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    private String configLocation;

    public ClassPathXmlApplicationContext(String configLocation) throws Exception {
        this(configLocation,new AutowireCapableBeanFactory());
    }

    public ClassPathXmlApplicationContext(String configLocation,AbstractBeanFactory beanFactory) throws Exception{
        super(beanFactory);
        this.configLocation = configLocation;
        refresh();
    }


    public void refresh()throws Exception{

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinition(this.configLocation);
        Map<String,BeanDefinition> beanMap = xmlBeanDefinitionReader.getRegistry();
        for (Map.Entry<String,BeanDefinition> entry: beanMap.entrySet()){
            beanFactory.registerBeanDefinition(entry.getKey(),entry.getValue());
        }
        beanFactory.initiateSingletons();
    }
    }

