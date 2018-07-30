package com.cyliu.tinyioc.beans;

import java.io.IOException;

public interface BeanDefinitionReader {
    void loadBeanDefinition(String url) throws Exception;
}
