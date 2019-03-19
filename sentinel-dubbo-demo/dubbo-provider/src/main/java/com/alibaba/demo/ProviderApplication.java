package com.alibaba.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Run with the JVM parameter:
 * <pre>
 * -Djava.net.preferIPv4Stack=true -Dproject.name=dubbo-provider -Dahas.license=xxx
 * </pre>
 *
 * @author leyou
 */
@SpringBootApplication(scanBasePackages = "com.alibaba.demo")
public class ProviderApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ProviderApplication.class, args);
        System.out.println("context=" + context);
    }
}
