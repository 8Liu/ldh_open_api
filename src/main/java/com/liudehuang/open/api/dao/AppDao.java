package com.liudehuang.open.api.dao;

import com.liudehuang.open.api.entity.AppEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author liudehuang
 * @date 2019/2/9 8:18
 */
@Repository
public interface AppDao {
    /**
     * 根据appId和appSecret查找相关信息
     * @param appEntity
     * @return
     */
    AppEntity findApp(AppEntity appEntity);


    /**
     * 根据appId更新accessToken
     * @return
     */
    int updateAccessToken(@Param("accessToken") String accessToken, @Param("appId") String appId);
}
