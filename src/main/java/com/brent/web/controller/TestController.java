package com.brent.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by brent.su on 2016/5/19.
 */
@Controller
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String test() {
        return "test successfully";
    }

    @RequestMapping(value = "/test/view", method = RequestMethod.GET)
    public String testView() {
        return "hello";
    }
}
