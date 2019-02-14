package com.liudehuang.open.api.service.impl;

import com.liudehuang.open.api.base.BaseApiService;
import com.liudehuang.open.api.base.ResponseBase;
import com.liudehuang.open.api.service.OpenService;
import org.springframework.stereotype.Service;

/**
 * @author liudehuang
 * @date 2019/2/13 17:02
 */
@Service("openService")
public class OpenServiceImpl extends BaseApiService implements OpenService {
    @Override
    public ResponseBase getUser() {
        return setResultSuccess("可以正式调用接口了");
    }
}
