package com.gederin.beanpostprocessors.afterinit;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class ProfilingAnnotationBeanPostProcessor implements BeanPostProcessor {

    private Map<String, Class> beanNameToClassMap = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        Class<?> beanClass = bean.getClass();

        if (beanClass.isAnnotationPresent(EnableProfiling.class)){
            beanNameToClassMap.put(beanName, beanClass);
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = beanNameToClassMap.get(beanName);

        if (Objects.nonNull(beanClass)){
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), (proxy, method, args) -> {
                System.out.println("profiling start...");
                long before = System.nanoTime();

                Object retVal = method.invoke(bean, args);

                long after = System.nanoTime();
                System.out.println("profiling end. " + method.getName() + " invokation took " + (after - before) + " nanos");

                return retVal;
            });
        }

        return bean;
    }
}
