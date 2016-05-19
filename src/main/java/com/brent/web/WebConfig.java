package com.brent.web;

import com.brent.core.AbstractWebConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by brent.su on 2016/5/19.
 */
@Configuration
@ComponentScan(basePackages = {"com.brent.web.controller"})
public class WebConfig extends AbstractWebConfig {

}
