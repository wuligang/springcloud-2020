package com.hisoft.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String search(){
        return "search"+port;
    }
}
