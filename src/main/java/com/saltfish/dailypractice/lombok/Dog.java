package com.saltfish.dailypractice.lombok;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
// 添加这个注解后子类生成的equals和hashcode方法会包含父类字段，否则不包含父类字段
@EqualsAndHashCode(callSuper = true)
public class Dog extends Animals{

    private String cry;
}
