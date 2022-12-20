package com.saltfish.dailypractice.concurrent.future;

import com.saltfish.dailypractice.concurrent.future.entity.MedalInfo;
import com.saltfish.dailypractice.concurrent.future.entity.UserInfo;
import com.saltfish.dailypractice.concurrent.future.service.MedalService;
import com.saltfish.dailypractice.concurrent.future.service.UserInfoService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * CompletableFuture测试
 *
 */
public class CompletableFutureTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        UserInfoService userInfoService = new UserInfoService();
        MedalService medalService = new MedalService();
        long userId = 888888L;
        long startTime = System.currentTimeMillis();

        CompletableFuture<UserInfo> userInfoCompletableFuture = CompletableFuture.supplyAsync(() -> userInfoService.getUserInfo(userId));

        Thread.sleep(300);

        CompletableFuture<MedalInfo> medalInfoCompletableFuture = CompletableFuture.supplyAsync(() -> medalService.getMedalInfo(userId));

        userInfoCompletableFuture.get();
        medalInfoCompletableFuture.get();

        System.out.printf("总共用时%d毫秒", System.currentTimeMillis() - startTime);
    }
}
