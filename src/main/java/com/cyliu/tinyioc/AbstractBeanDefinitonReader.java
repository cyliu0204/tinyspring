package com.cyliu.tinyioc;

import com.cyliu.tinyioc.io.ResourceLoader;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractBeanDefinitonReader implements BeanDefinitionReader {
    private ResourceLoader resourceLoader;
    private Map<String,BeanDefinition> registry= new ConcurrentHashMap<>();

    public AbstractBeanDefinitonReader(ResourceLoader resourceLoader){
        this.resourceLoader = resourceLoader;
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

}
