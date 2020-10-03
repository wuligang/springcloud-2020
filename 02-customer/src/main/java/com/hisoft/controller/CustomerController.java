package com.hisoft.controller;

import com.hisoft.client.SearchClient;
import com.hisoft.pojo.Customer;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/search/{id}")
    public Customer findById(@PathVariable Integer id) {
        return searchClient.findById(id);
    }

    @GetMapping("/getCustomer")
    public Customer getCustomer(@RequestParam Integer id, @RequestParam String name){
        return searchClient.getCustomer(id,name);
    }

    @GetMapping("/save")        //会自动转为post请求   405
    public Customer save(Customer customer){
        return searchClient.save(customer);
    }
}
