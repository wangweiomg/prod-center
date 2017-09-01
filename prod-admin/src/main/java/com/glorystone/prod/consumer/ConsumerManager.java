package com.glorystone.prod.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.glorystone.prod.provider.hello.service.HelloService;
import lombok.Getter;
import org.springframework.stereotype.Component;

/**
 * Created by wangwei on 2017/8/30.
 */
@Component
public @Getter class ConsumerManager {

    @Reference
    private HelloService helloService;



}
