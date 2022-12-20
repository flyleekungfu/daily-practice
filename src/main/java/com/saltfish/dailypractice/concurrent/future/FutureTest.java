package com.saltfish.dailypractice.concurrent.future;

import com.saltfish.dailypractice.concurrent.future.entity.MedalInfo;
import com.saltfish.dailypractice.concurrent.future.entity.UserInfo;
import com.saltfish.dailypractice.concurrent.future.service.MedalService;
import com.saltfish.dailypractice.concurrent.future.service.UserInfoService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Future测试
 *
 */
public class FutureTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        UserInfoService userInfoService = new UserInfoService();
        MedalService medalService = new MedalService();
        long userId = 888888L;
        long startTime = System.currentTimeMillis();

        FutureTask<UserInfo> userInfoFutureTask = new FutureTask<>(() -> userInfoService.getUserInfo(userId));
        executorService.submit(userInfoFutureTask);

        // 模拟主线程其他操作耗时
        Thread.sleep(300);

        FutureTask<MedalInfo> medalFutureTask = new FutureTask<>(() -> medalService.getMedalInfo(userId));
        executorService.submit(medalFutureTask);

        UserInfo userInfo = userInfoFutureTask.get();
        MedalInfo medalInfo = medalFutureTask.get();

        System.out.printf("总共用时%d毫秒", System.currentTimeMillis() - startTime);
    }
}
