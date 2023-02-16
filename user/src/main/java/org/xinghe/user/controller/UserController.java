package org.xinghe.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述
 *
 * @author 星河君❀❀ 2023/2/16 20:16
 * @see [相关类/方法]
 * @since [版本号]
 */
@RestController
@Slf4j
public class UserController {

    @GetMapping("/user/getUserById")
    public String getUser(Long userId) {
        log.info("getUserById userId : {}", userId);
        return "星河";
    }
}
