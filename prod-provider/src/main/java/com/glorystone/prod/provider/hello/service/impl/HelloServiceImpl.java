package com.glorystone.prod.provider.hello.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.glorystone.prod.provider.hello.service.HelloService;

/**
 * Created by wangwei on 2017/8/29.
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHi(String name) {
        return "hello, rose like " + name;
    }
}
