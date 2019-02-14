package com.liudehuang.open.api.controller;

import com.liudehuang.open.api.base.ResponseBase;
import com.liudehuang.open.api.service.OpenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liudehuang
 * @date 2019/2/13 17:01
 */
@RestController
@RequestMapping("/openApi")
public class OpenController {
    @Autowired
    private OpenService openService;
    @RequestMapping("/getUser")
    public ResponseBase getUser(){
        return openService.getUser();
    }

}
