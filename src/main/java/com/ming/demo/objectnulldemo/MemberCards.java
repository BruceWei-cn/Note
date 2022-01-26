package com.ming.demo.objectnulldemo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ming
 * @date 26/1/2022-下午 2:10
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberCards {
    private String sourceUrl;

    /**
     * 前端航司会员卡 右下角背景图标url
     */
    private String iconUrl;

    /**
     * 忘记密码url
     */
    private String resetPasswordUrl;
    /**
     * 航司登录url
     */
    private String registerUrl;
}
