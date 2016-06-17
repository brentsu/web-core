package com.brent.core;

import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

/**
 * Created by brent.su on 2016/6/13.
 */
public class DefaultFreemarkerViewResolver extends FreeMarkerViewResolver {

    public String buildFullTemplatePath(String template) {
        return String.format("%s%s%s", getPrefix(), template, getSuffix());
    }
}
