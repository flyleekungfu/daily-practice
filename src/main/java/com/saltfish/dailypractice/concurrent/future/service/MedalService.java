package com.saltfish.dailypractice.concurrent.future.service;

import com.saltfish.dailypractice.concurrent.future.entity.MedalInfo;

/**
 * 模拟勋章服务
 *
 */
public class MedalService {

    public MedalInfo getMedalInfo(Long userId){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return new MedalInfo(888888L, "测试勋章");
    }
}
