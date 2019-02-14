package com.liudehuang.open.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liudehuang
 * @date 2019/2/13 14:41
 */
@MapperScan("com.liudehuang.open.api.dao")
@SpringBootApplication
public class OpenApp {
    public static void main(String[] args) {
        SpringApplication.run(OpenApp.class, args);
    }
}
