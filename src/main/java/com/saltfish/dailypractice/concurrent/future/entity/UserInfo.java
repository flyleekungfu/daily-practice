package com.saltfish.dailypractice.concurrent.future.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户信息
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    
    /**
     * 主键
     */
    private Long id;
    
    /**
     * 姓名
     */
    private String realName;
    
    /**
     * 年龄
     */
    private Integer age;
}
