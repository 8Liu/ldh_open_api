package com.liudehuang.open.api.controller;

import com.liudehuang.open.api.base.ResponseBase;
import com.liudehuang.open.api.entity.AppEntity;
import com.liudehuang.open.api.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liudehuang
 * @date 2019/2/9 8:49
 */
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @RequestMapping("/getAccessToken")
    public ResponseBase getAccessToken(AppEntity appEntity){
        return authService.getAccessToken(appEntity);
    }


}
