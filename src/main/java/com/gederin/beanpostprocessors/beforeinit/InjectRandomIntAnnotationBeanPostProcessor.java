package com.gederin.beanpostprocessors.beforeinit;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Stream;

@Component
public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        Stream.of(bean.getClass()
                .getDeclaredFields())
                .filter(field -> Objects.nonNull(field.getAnnotation(InjectRandomInt.class)))
                .forEach(field -> generateRandomIntAndSetInField(field, bean));

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    private void generateRandomIntAndSetInField(Field field, Object bean) {
        InjectRandomInt injectRandomInt = field.getAnnotation(InjectRandomInt.class);

        int randomValue = injectRandomInt.min() + new Random().nextInt(injectRandomInt.max() - injectRandomInt.min());

        field.setAccessible(true);
        ReflectionUtils.setField(field, bean, randomValue);
    }
}
