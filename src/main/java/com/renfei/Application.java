package com.renfei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Created with IntelliJ IDEA
 * Author: songrenfei
 * Date: 15/9/7
 * Time: 下午11:54
 */

/*@Configuration
@ComponentScan
@EnableAutoConfiguration*/
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
