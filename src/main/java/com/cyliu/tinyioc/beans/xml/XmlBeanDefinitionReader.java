package com.cyliu.tinyioc.beans.xml;

import com.cyliu.tinyioc.beans.AbstractBeanDefinitonReader;
import com.cyliu.tinyioc.beans.BeanDefinition;
import com.cyliu.tinyioc.BeanReference;
import com.cyliu.tinyioc.beans.PropertyValue;
import com.cyliu.tinyioc.beans.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

public class XmlBeanDefinitionReader extends AbstractBeanDefinitonReader {



    public XmlBeanDefinitionReader(ResourceLoader resourceLoader){
        super(resourceLoader);
    }

    @Override
    public void loadBeanDefinition(String url) throws Exception {
        InputStream inputStream = getResourceLoader().getResource(url).getInputStream();
        doLoadBeanDefinitions(inputStream);
    }

    private void doLoadBeanDefinitions(InputStream inputStream) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document doc = documentBuilder.parse(inputStream);
        registerDocument(doc);
        inputStream.close();
    }

    private void registerDocument(Document doc) {
        Element root = doc.getDocumentElement();
        parseBeanDefinitions(root);
    }

    private void parseBeanDefinitions(Element root) {
        NodeList nodeList = root.getChildNodes();
        for (int i = 0; i<nodeList.getLength(); i++){
            Node node = nodeList.item(i);
            if (node instanceof Element){
                Element ele = (Element) node;
                processBeanDefinition(ele);
            }
        }
    }

    /**
     * 加入注册
     * @param ele
     */
    private void processBeanDefinition(Element ele) {
        String className = ele.getAttribute("class");
        String name = ele.getAttribute("name");
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName(className);
        processBeanValues(beanDefinition,ele);
        getRegistry().put(name,beanDefinition);
    }

    private void processBeanValues(BeanDefinition beanDefinition, Element ele) {
        NodeList nodeList = ele.getElementsByTagName("property");
        for (int i = 0; i<nodeList.getLength(); i++){
            Node node = nodeList.item(i);
            if (node instanceof Element){
                Element propertyEle = (Element) node;
                String name = propertyEle.getAttribute("name");
                String value = propertyEle.getAttribute("value");
                if(value != null && value.length() > 0) {
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, value));
                } else {
                    String ref = propertyEle.getAttribute("ref");
                    if (ref == null || ref.length() == 0) {
                        throw new IllegalArgumentException("Configuration problem: <property> element for property '"
                                + name + "' must specify a ref or value");
                    }
                    BeanReference beanReference = new BeanReference(ref);
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, beanReference));
                }


            }
        }
    }
}
