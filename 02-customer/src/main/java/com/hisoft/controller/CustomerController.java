package com.hisoft.controller;

import com.hisoft.client.SearchClient;
import com.hisoft.pojo.Customer;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
        System.out.println(Thread.currentThread().getName());
        return searchClient.search();
    }

    @GetMapping("/search/{id}")
    @HystrixCommand(fallbackMethod = "findByIdFallBack")
    public Customer findById(@PathVariable Integer id) {
        System.out.println(Thread.currentThread().getName());
        int a = 1 / 0;
        return searchClient.findById(id);
    }

    //findById 的降级方法，方法描述要一模一样
    public Customer findByIdFallBack(@PathVariable Integer id) {
        return new Customer(-1,"",0);
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
