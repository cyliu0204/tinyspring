package com.cyliu;

import com.cyliu.tinyioc.context.ApplicationContext;
import com.cyliu.tinyioc.context.ClassPathXmlApplicationContext;
import org.junit.Test;

public class ClassPathXmlApplicationContextTest {
    @Test
    public void test() throws Exception {
            ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("tinyioc.xml");
            AppTest appTest = (AppTest) classPathXmlApplicationContext.getBean("appTest");
            appTest.sayHi();
    }
}
