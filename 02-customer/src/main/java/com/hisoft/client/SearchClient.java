package com.hisoft.client;

import com.hisoft.factory.SearchClientFallBackFactory;
import com.hisoft.fallback.SearchClientFallBack;
import com.hisoft.pojo.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @program: springcloud
 * @description:
 * @author: wlg
 * @create: 2020-10-03 17:17:09
 **/
@FeignClient(value = "SEARCH",//指定服务名称
        /*fallback = SearchClientFallBack.class,*/
        fallbackFactory = SearchClientFallBackFactory.class)
public interface SearchClient {
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    String search();

    @RequestMapping(value = "/search/{id}", method = RequestMethod.GET)
    Customer findById(@PathVariable Integer id);

    @RequestMapping(value = "/getCustomer", method = RequestMethod.GET)
    Customer getCustomer(@RequestParam Integer id, @RequestParam String name);

    @RequestMapping(value = "/save", method = RequestMethod.GET)
        //会自动转为post请求   405
    Customer save(Customer customer);
}
