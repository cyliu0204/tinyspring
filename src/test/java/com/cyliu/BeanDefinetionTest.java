package com.cyliu;

import com.cyliu.tinyioc.beans.factory.AutowireCapableBeanFactory;
import com.cyliu.tinyioc.beans.BeanDefinition;
import com.cyliu.tinyioc.beans.factory.BeanFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Queue;

public class BeanDefinetionTest {



    public static void main(String[] args) throws Exception {
//        BeanFactory beanFactory = new AutowireCapableBeanFactory();
//        BeanDefinition beanDefinition = new BeanDefinition();
//        beanDefinition.setBeanClassName("com.cyliu.AppTest");
//        beanFactory.registerBeanDefinition("appTest",beanDefinition);
//
//        AppTest appTest = (AppTest) beanFactory.getBean("appTest");
//        appTest.sayHi();
        URL url = new URL("http://www.zhihu.com");
        InputStream is = url.openStream(); // 字节流
        InputStreamReader isr = new InputStreamReader(is, "utf-8");                              // 字符流
        BufferedReader br = new BufferedReader(isr);
        String line = br.readLine();
        while (line != null) {
            System.out.println(line);
            line = br.readLine();
        }
        br.close();
        isr.close();
        is.close();
    }
}
