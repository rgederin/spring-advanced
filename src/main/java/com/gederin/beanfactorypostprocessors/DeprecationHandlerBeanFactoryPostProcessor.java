package com.gederin.beanfactorypostprocessors;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Stream;

@Component
public class DeprecationHandlerBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        Stream.of(beanFactory.getBeanDefinitionNames()).forEach(name -> {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);

            String beanClassName = beanDefinition.getBeanClassName();
            try {
                Class<?> beanClass = Class.forName(beanClassName);
                DeprecatedClass annotation = beanClass.getAnnotation(DeprecatedClass.class);

                if (Objects.nonNull(annotation)) {
                    beanDefinition.setBeanClassName(annotation.newImplementation().getName());
                }

            } catch (Exception e) {
            }
        });
    }
}
