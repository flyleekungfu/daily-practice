package com.saltfish.dailypractice.designpattern.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SingletonTest {

    @Test
    public void testHungrySingleton() {
        HungrySingleton hungrySingleton = HungrySingleton.getInstance();
        System.out.println(hungrySingleton);
    }

    @Test
    public void testLazySingleton() {
        LazySingleton lazySingleton = LazySingleton.getInstance();
        System.out.println(lazySingleton);
    }

    @Test
    public void testStaticSingleton() {
        StaticSingleton staticSingleton = StaticSingleton.getInstance();
        System.out.println(staticSingleton);
    }

    @Test
    public void testEnumSingleton() {
        System.out.println(EnumSingleton.getInstance());
    }
}
