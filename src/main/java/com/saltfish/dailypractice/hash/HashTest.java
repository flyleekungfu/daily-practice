package com.saltfish.dailypractice.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * hash测试
 * ps：测试User方法重写与不重写hashCode的区别
 *
 * @author saltfish
 * @date 2021/6/22 10:35
 */
public class HashTest {

    public static void main(String[] args) {
        Set<User> users = new HashSet<>();

        for (int i = 0, size = 10; i < size; i++) {
            User user = new User();
            user.setId("1")
                    .setName("小明")
                    .setAge(18);
            users.add(user);
        }

        System.out.println(users.size());
    }
}
