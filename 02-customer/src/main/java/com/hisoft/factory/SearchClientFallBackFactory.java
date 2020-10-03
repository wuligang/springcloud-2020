package com.hisoft.factory;

import com.hisoft.client.SearchClient;
import com.hisoft.fallback.SearchClientFallBack;
import feign.hystrix.FallbackFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: springcloud
 * @description:
 * @author: wlg
 * @create: 2020-10-03 19:45:09
 **/
@Component
public class SearchClientFallBackFactory implements FallbackFactory<SearchClient> {
    @Autowired
    private SearchClientFallBack searchClientFallBack;
    @Override
    public SearchClient create(Throwable throwable) {
        throwable.printStackTrace();
        return searchClientFallBack;
    }
}
