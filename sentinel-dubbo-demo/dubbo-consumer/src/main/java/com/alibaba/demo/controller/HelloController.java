package com.alibaba.demo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.demo.HelloService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author leyou
 */
@RestController
@DubboComponentScan
public class HelloController {
    @Reference(url = "dubbo://127.0.0.1:25758", timeout = 5000)
    private HelloService helloService;

    @RequestMapping("/hello")
    public Map<String, String> hello(String msg,
                                     @RequestParam(required = false, defaultValue = "false") Boolean slow) {
        Map<String, String> map = new HashMap<>(4);
        map.put("date", new Date().toString());
        String hello;
        try {
            if (slow) {
                hello = helloService.helloSlow(msg, 100);
            } else {
                hello = helloService.hello(msg);
            }
        } catch (Exception e) {
            hello = "exception: " + e.getCause();
        }
        map.put("msg", hello);
        return map;
    }
}
