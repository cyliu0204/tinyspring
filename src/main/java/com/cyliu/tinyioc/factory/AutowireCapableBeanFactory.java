package com.cyliu.tinyioc.factory;

import com.cyliu.tinyioc.BeanDefinition;
import com.cyliu.tinyioc.PropertyValue;
import com.cyliu.tinyioc.PropertyValues;

import java.lang.reflect.Field;
import java.util.List;

public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    public Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object object = createInstance(beanDefinition);
        //针对初始化bean时候的赋值
        setPropertyValues(object,beanDefinition);
        return object;
    }

    private Object createInstance(BeanDefinition beanDefinition) throws Exception{
            Object target = beanDefinition.getBeanClass().newInstance();
            return  target;
    }

    private void setPropertyValues(Object object, BeanDefinition beanDefinition) throws Exception {
        List<PropertyValue> propertyValueList = beanDefinition.getPropertyValues().getPropertyValues();
        for (PropertyValue propertyValue: propertyValueList){
             Field field = object.getClass().getDeclaredField(propertyValue.getName());
             field.setAccessible(true);
             field.set(object, propertyValue.getValue());
        }
    }

}
