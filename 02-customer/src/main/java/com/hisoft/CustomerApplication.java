package com.hisoft;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @program: springcloud
 * @description:
 * @author: wlg
 * @create: 2020-10-02 11:22:09
 **/
@SpringBootApplication
@EnableEurekaClient//新版可以省略
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrixDashboard
@ServletComponentScan("com.hisoft.servlet")
public class CustomerApplication {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    /*@Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }*/

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class,args);
    }
}
