package com.example;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.example.dao")
public class Application {
    public static void main( String[] args ) {
        SpringApplication.run(Application.class,args);
        System.out.println("app 项目已启动...");
    }
}
