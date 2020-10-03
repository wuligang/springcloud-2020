package com.hisoft.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @program: springcloud
 * @description:
 * @author: wlg
 * @create: 2020-10-03 17:17:09
 **/
@FeignClient("SEARCH")  //指定服务名称
public interface SearchClient {
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    String search();
}
