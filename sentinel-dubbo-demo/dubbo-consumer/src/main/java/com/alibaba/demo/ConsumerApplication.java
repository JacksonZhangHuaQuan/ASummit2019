package com.alibaba.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Run with the JVM parameter:
 * <pre>
 * -Djava.net.preferIPv4Stack=true -Dproject.name=dubbo-consumer -Dahas.license=xxx
 * </pre>
 * To run the consumer application, we should start dubbo provider first.
 *
 * @author leyou
 */
@SpringBootApplication(scanBasePackages = "com.alibaba.demo.*")
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
