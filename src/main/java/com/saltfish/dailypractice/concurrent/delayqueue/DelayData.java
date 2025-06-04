package com.saltfish.dailypractice.concurrent.delayqueue;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayData implements Delayed {

    // 延迟对象的排序字段
    @Getter
    @Setter
    private Integer number;

    @Override
    public long getDelay(TimeUnit unit) {
        return 5;
    }

    @Override
    public int compareTo(Delayed o) {
        return this.number.compareTo(((DelayData) o).getNumber());
    }
}
