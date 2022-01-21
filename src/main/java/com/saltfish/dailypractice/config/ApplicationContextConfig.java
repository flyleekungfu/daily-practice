package com.saltfish.dailypractice.config;

import com.saltfish.dailypractice.spring.ApplicationContextAwareDemo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class ApplicationContextConfig {

    @Bean(initMethod = "init")
    public ApplicationContextAwareDemo getApplicationContextAwareDemo() {
        log.info("ApplicationContextAwareDemo创建");
        return new ApplicationContextAwareDemo();
    }
}
