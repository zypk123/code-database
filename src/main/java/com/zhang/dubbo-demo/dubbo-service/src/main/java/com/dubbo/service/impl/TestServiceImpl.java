package com.dubbo.service.impl;

import com.dubbo.service.TestService;

/**
 * @author zhangyu
 * @create 2018-07-12 19:01
 **/
public class TestServiceImpl implements TestService {

    @Override
    public String sayHello(String name) {
        return name + " service2 say hello word service2!";
    }
}
