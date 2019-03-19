package com.alibaba.demo.config;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.annotation.PostConstruct;
import javax.servlet.Filter;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.csp.sentinel.adapter.servlet.CommonFilter;
import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
import com.alibaba.csp.sentinel.adapter.servlet.callback.WebCallbackManager;
import com.alibaba.csp.sentinel.slots.block.BlockException;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author leyou
 */
@Configuration
public class WebConfig {

    /**
     * 自定义web url被限流后的fallback页面，通过重载{@link UrlBlockHandler#blocked(HttpServletRequest,
     * HttpServletResponse, BlockException)}方法可以灵活的自定义限流页面。
     */
    //@PostConstruct
    public void setWebBlockHandler() {
        WebCallbackManager.setUrlBlockHandler(new UrlBlockHandler() {
            @Override
            public void blocked(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                BlockException e) throws IOException {
                ServletOutputStream outputStream = httpServletResponse.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
                // 自定义限流页面
                writer.write("Self defined block page, block reason: " + e.getClass().getSimpleName());
                writer.flush();
            }
        });
    }

    /**
     * 注册Sentinel的{@link CommonFilter}作为应用的web filter。通过该filter，Sentinel会拦截
     * 所有请求，并采用对应的流控降级策略。
     *
     * @return filter registration bean.
     */
    @Bean
    public FilterRegistrationBean sentinelFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new CommonFilter());
        registration.addUrlPatterns("/*");
        registration.setName("sentinelCommonFilter");
        registration.setOrder(1);
        return registration;
    }
}
