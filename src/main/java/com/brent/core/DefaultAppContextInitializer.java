package com.brent.core;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.web.context.ConfigurableWebApplicationContext;

import java.io.IOException;

/**
 * Created by brent.su on 2016/5/19.
 */
public class DefaultAppContextInitializer implements ApplicationContextInitializer<ConfigurableWebApplicationContext> {
    @Override
    public void initialize(ConfigurableWebApplicationContext context) {
        try {
            context.getEnvironment().setIgnoreUnresolvableNestedPlaceholders(true);

            Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath*:*.properties");
            MutablePropertySources propertySources = context.getEnvironment().getPropertySources();
            for (Resource resource : resources) {
                if (!propertySources.contains(resource.getFilename())) {
                    propertySources.addLast(new ResourcePropertySource(resource.getFilename(), resource));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
