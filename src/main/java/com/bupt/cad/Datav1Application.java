package com.bupt.cad;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.bupt.cad.mapper")
@SpringBootApplication
public class Datav1Application {

    public static void main(String[] args) {
        SpringApplication.run(Datav1Application.class, args);
    }

}