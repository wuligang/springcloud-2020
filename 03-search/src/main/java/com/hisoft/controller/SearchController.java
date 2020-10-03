package com.hisoft.controller;

import com.hisoft.pojo.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @program: springcloud
 * @description:
 * @author: wlg
 * @create: 2020-10-02 12:19:32
 **/
@RestController
public class SearchController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/search")
    public String search() {
        int a = 10 / 0;//测试fallback
        return "search" + port;
    }

    @GetMapping("/search/{id}")
    public Customer findById(@PathVariable Integer id) {
        return new Customer(id, "张三", 22);
    }

    @GetMapping("/getCustomer")
    public Customer getCustomer(@RequestParam Integer id, @RequestParam String name) {
        return new Customer(id, name, 22);
    }

    @PostMapping("/save")        //会自动转为post请求   405
    public Customer save(@RequestBody Customer customer) {
        return customer;
    }
}
