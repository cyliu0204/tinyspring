package com.cyliu.tinyioc;

import java.io.IOException;

public interface BeanDefinitionReader {
    void loadBeanDefinition(String url) throws Exception;
}
