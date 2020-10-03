package com.hisoft.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @program: springcloud
 * @description:
 * @author: wlg
 * @create: 2020-10-02 12:22:10
 **/
@RestController
public class CustomerController {
    @Autowired
    private RestTemplate restTemplate;
    @Resource
    private EurekaClient eurekaClient;

    @GetMapping("/customer")
    public String customer() {
        /*//1.通过eurekaClient获取到search服务信息
        InstanceInfo info = eurekaClient.getNextServerFromEureka("SEARCH", false);
        //2.获取到访问的地址
        String url = info.getHomePageUrl();
        //3.通过restTemplate访问
        String result = restTemplate.getForObject(url + "/search", String.class);*/
        String result = restTemplate.getForObject("http://SEARCH/search",String.class);
        //4.返回
        return result;
    }
}
