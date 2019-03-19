package com.alibaba.demo;

/**
 * @author leyou
 */
public interface HelloService {
    /**
     * say hello
     *
     * @param msg
     * @return
     */
    String hello(String msg);

    /**
     * 加入random sleep时间，模拟请求rt。
     *
     * @param msg
     * @param sleep
     * @return
     */
    String helloSlow(String msg, long sleep);
}
