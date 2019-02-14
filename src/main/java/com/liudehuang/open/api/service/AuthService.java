package com.liudehuang.open.api.service;

import com.liudehuang.open.api.base.ResponseBase;
import com.liudehuang.open.api.entity.AppEntity;

/**
 * @author liudehuang
 * @date 2019/2/9 8:57
 */
public interface AuthService {
    /**
     * 获取accessToken
     * @param appEntity
     * @return
     */
    ResponseBase getAccessToken(AppEntity appEntity);

}
