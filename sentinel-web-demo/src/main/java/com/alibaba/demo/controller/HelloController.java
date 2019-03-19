package com.alibaba.demo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author leyou
 */
@RestController
public class HelloController {

    /**
     * 一个简单的web接口，返回用户输入的信息。当限流规则后，我们将看到fallback页面。
     *
     * @param msg
     * @return
     */
    @RequestMapping(value = {"/hello", "/"})
    public Map<String, Object> hello(String msg) {

        Map<String, Object> map = new HashMap<>(4);
        map.put("msg", "hello " + msg);
        map.put("date", new Date().toString());
        return map;
    }

    /**
     * 使用随机sleep模拟请求RT。
     *
     * @param msg
     * @return
     */
    @RequestMapping("/helloRandomSleep")
    public Map<String, Object> helloRandomSleep(String msg) {
        Map<String, Object> map = new HashMap<>(4);
        map.put("msg", "hello " + msg);
        map.put("date", new Date().toString());

        try {
            int sleep = 50 + ThreadLocalRandom.current().nextInt(20);
            Thread.sleep(sleep);
            map.put("sleep", sleep);
        } catch (InterruptedException ignore) { }
        return map;
    }
}
