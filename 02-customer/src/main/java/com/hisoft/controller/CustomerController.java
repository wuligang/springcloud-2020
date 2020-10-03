package com.hisoft.controller;

import com.hisoft.client.SearchClient;
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
    private SearchClient searchClient;

    @GetMapping("/customer")
    public String customer() {
        return searchClient.search();
    }
}
