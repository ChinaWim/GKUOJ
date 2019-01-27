package com.oj.gkuoj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.concurrent.Callable;

@SpringBootApplication
@MapperScan("com.oj.gkuoj.dao")
@EnableTransactionManagement
public class GkuojApplication {

    public static void main(String[] args) {
        SpringApplication.run(GkuojApplication.class, args);
    }
}
