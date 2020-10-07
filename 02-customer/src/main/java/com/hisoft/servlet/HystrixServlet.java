package com.hisoft.servlet;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

import javax.servlet.annotation.WebServlet;

/**
 * @program: springcloud
 * @description:
 * @author: wlg
 * @create: 2020-10-04 21:07:11
 **/
@WebServlet("/hystrix.stream")
public class HystrixServlet extends HystrixMetricsStreamServlet {
}
