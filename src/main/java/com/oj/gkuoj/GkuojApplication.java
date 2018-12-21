package com.oj.gkuoj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.oj.gkuoj.dao")
@EnableTransactionManagement
public class GkuojApplication {

    public static void main(String[] args) {
        SpringApplication.run(GkuojApplication.class, args);
    }
}
