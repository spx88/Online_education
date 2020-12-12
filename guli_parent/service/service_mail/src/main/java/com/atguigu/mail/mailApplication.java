package com.atguigu.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName: mailApplication
 * @description: TODO
 * @author: spx
 * @create: 2020-12-07 10:43
 * @Version 1.0
 **/

@ComponentScan(basePackages = {"com.atguigu"})
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class mailApplication {
    public static void main(String[] args) {
        SpringApplication.run(mailApplication.class, args);
    }

}
