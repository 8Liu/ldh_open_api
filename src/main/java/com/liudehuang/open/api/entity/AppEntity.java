package com.liudehuang.open.api.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liudehuang
 * @date 2019/2/6 10:31
 */
@Slf4j
@Getter
@Setter
public class AppEntity {
    /**
     * 自增id
     */
    private String id;
    /**
     * appId
     */
    private String appId;
    /**
     * 机构名称
     */
    private String appName;
    /**
     * 密钥
     */
    private String appSecret;
    /**
     * 令牌
     */
    private String accessToken;
    /**
     * 是否启用
     */
    private Integer isFlag;

    private String createTime;

    private String updateTime;
}
