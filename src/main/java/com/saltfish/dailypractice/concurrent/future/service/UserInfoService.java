package com.saltfish.dailypractice.concurrent.future.service;

import com.saltfish.dailypractice.concurrent.future.entity.UserInfo;

/**
 * 模拟查询用户信息服务
 *
 */
public class UserInfoService {

    public UserInfo getUserInfo(Long userId) {
        // 模拟调用耗时
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // 一般是查数据库，或者远程调用返回的
        return new UserInfo(888888L, "小明", 28);
    }
}
