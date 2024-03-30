package com.code.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.code.server.mapper")
public class WalkServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WalkServerApplication.class, args);
    }

}
