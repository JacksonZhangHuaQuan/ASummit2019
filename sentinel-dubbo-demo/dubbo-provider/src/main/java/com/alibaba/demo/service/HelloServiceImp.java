package com.alibaba.demo.service;

import com.alibaba.demo.HelloService;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * @author leyou 2018/12/30
 */
@Service
public class HelloServiceImp implements HelloService {
    @Override
    public String hello(String msg) {
        return "Dubbo Service: Hello " + msg;
    }

    @Override
    public String helloSlow(String msg, long sleep) {
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Dubbo Slow Service: Hello " + msg;
    }
}
