package com.liudehuang.open.api.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.liudehuang.open.api.base.BaseApiService;
import com.liudehuang.open.api.base.BaseRedisService;
import com.liudehuang.open.api.base.ResponseBase;
import com.liudehuang.open.api.constants.Constants;
import com.liudehuang.open.api.dao.AppDao;
import com.liudehuang.open.api.entity.AppEntity;
import com.liudehuang.open.api.service.AuthService;
import com.liudehuang.open.api.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author liudehuang
 * @date 2019/2/13 14:12
 */
@Service("authService")
public class AuthServiceImpl extends BaseApiService implements AuthService {
    @Autowired
    private BaseRedisService baseRedisService;
    @Autowired
    private AppDao appDao;


    @Override
    public ResponseBase getAccessToken(AppEntity appEntity) {
        //1. 获取生成的对应的appId和appSecret,验证是否可用
        //2. 删除之前的accessToken
        //3. 使用对应机构的appId和appSecret生成对应的accessToken
        //4. 返回最新的accessToken
        //根据appId和appSecret查询对应的信息
        AppEntity appResult = appDao.findApp(appEntity);
        if (appResult == null) {
            return setResultError("没有对应机构的认证信息");
        }
        int isFlag = appResult.getIsFlag();
        if (isFlag == 1) {
            return setResultError("您现在没有权限生成对应的AccessToken");
        }
        // ### 获取新的accessToken 之前删除之前老的accessToken
        // 从redis中删除之前的accessToken
        String accessToken = appResult.getAccessToken();
        if(!StringUtils.isEmpty(accessToken)){
            baseRedisService.delKey(accessToken);
        }
        // 生成的新的accessToken
        String newAccessToken = newAccessToken(appResult.getAppId());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("accessToken", newAccessToken);
        return setResultSuccessData(jsonObject);
    }

    private String newAccessToken(String appId) {
        // 使用appid+appsecret 生成对应的AccessToken 保存两个小时
        String accessToken = TokenUtils.getAccessToken();
        // 保证在同一个事物redis 事物中
        // 生成最新的token key为accessToken value 为 appid
        baseRedisService.setString(accessToken, appId, Constants.ACCESS_TOKEN_TIME_OUT);
        // 表中保存当前accessToken
        appDao.updateAccessToken(accessToken, appId);
        return accessToken;
    }


}
