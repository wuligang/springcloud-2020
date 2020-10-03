package com.hisoft.fallback;

import com.hisoft.client.SearchClient;
import com.hisoft.pojo.Customer;
import org.springframework.stereotype.Component;

/**
 * @program: springcloud
 * @description:
 * @author: wlg
 * @create: 2020-10-03 19:32:11
 **/
@Component
public class SearchClientFallBack implements SearchClient {
    @Override
    public String search() {
        return "出问题啦";
    }

    @Override
    public Customer findById(Integer id) {
        return null;
    }

    @Override
    public Customer getCustomer(Integer id, String name) {
        return null;
    }

    @Override
    public Customer save(Customer customer) {
        return null;
    }
}
