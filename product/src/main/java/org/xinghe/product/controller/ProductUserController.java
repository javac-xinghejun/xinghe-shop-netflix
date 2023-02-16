package org.xinghe.product.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xinghe.product.service.ProductUserService;

/**
 * 描述
 *
 * @author 星河君❀❀ 2023/2/16 20:18
 * @see [相关类/方法]
 * @since [版本号]
 */
@RestController
@Slf4j
public class ProductUserController {
    @Resource
    private ProductUserService productUserService;

    @GetMapping("/product/user/getUser")
    public String getUser(@RequestParam Long userId) {
        return productUserService.getUserId(userId);
    }
}
