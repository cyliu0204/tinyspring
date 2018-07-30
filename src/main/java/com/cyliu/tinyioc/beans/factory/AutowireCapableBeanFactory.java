package com.cyliu.tinyioc.beans.factory;

import com.cyliu.tinyioc.beans.BeanDefinition;
import com.cyliu.tinyioc.BeanReference;
import com.cyliu.tinyioc.beans.PropertyValue;

import java.lang.reflect.Field;
import java.util.List;

public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    public Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object object = createInstance(beanDefinition);
        //针对初始化bean时候的赋值
        setPropertyValues(object,beanDefinition);
        beanDefinition.setBean(object);
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
             Object value = propertyValue.getValue();
             if (value instanceof BeanReference){
                 BeanReference beanReference = (BeanReference) propertyValue.getValue();
                 value = getBean(beanReference.getRef());
             }

             field.set(object, value);
        }
    }

}
