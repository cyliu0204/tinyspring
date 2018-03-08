package com.cyliu.io;

import com.cyliu.tinyioc.io.Resource;
import com.cyliu.tinyioc.io.ResourceLoader;

import java.io.IOException;

import org.junit.Test;

import java.io.InputStream;
public class ResourceLoaderTest {

    @Test
    public void test() throws IOException {
        ResourceLoader resourceLoader = new ResourceLoader();
        Resource resource = resourceLoader.getResource("tinyioc.xml");
        InputStream inputStream = resource.getInputStream();
        org.junit.Assert.assertNotNull(inputStream);
    }
}