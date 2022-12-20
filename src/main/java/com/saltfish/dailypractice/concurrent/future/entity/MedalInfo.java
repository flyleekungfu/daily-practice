package com.saltfish.dailypractice.concurrent.future.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 勋章信息
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedalInfo {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 勋章名称
     */
    private String medalName;
}
