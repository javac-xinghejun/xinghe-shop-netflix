package org.xinghe.product.service.impl;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.xinghe.product.service.ProductUserService;

/**
 * 描述
 *
 * @author 星河君❀❀ 2023/2/16 20:21
 * @see [相关类/方法]
 * @since [版本号]
 */
@Service
@Slf4j
public class ProductUserServiceImpl implements ProductUserService {

    @Resource
    private LoadBalancerClient loadBalancerClient;
    @Resource
    private RestTemplate restTemplate;

    @Override
    public String getUserId(Long userId) {
        ServiceInstance serviceInstance = loadBalancerClient.choose("user");
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        String uri = "/user/getUserById?userId=" + userId;
        String url = "http://" + host + ":" + port + uri;
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }
}
