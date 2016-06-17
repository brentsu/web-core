package com.brent.web;

import com.brent.core.AbstractWebConfig;
import com.brent.core.DefaultFreemarkerViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

/**
 * Created by brent.su on 2016/5/19.
 */
@Configuration
@ComponentScan(basePackages = {"com.brent.web.controller"})
public class WebConfig extends AbstractWebConfig {

    @Bean
    DefaultFreemarkerViewResolver freeMarkerViewResolver() {
        DefaultFreemarkerViewResolver resolver = new DefaultFreemarkerViewResolver();
        resolver.setPrefix("/WEB-INF/templates/");
        resolver.setSuffix(".ftl");
        resolver.setContentType("text/html; charset=UTF-8");
        resolver.setViewClass(FreeMarkerView.class);
        resolver.setExposeSpringMacroHelpers(false);
        resolver.setExposeRequestAttributes(true);
        resolver.setAllowRequestOverride(true);
        return resolver;
    }



}
