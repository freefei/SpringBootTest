package com.renfei;

import com.renfei.configuration.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Created with IntelliJ IDEA
 * Author: songrenfei
 * Date: 15/9/7
 * Time: 下午11:54
 */


/*@Configuration //配置控制
@ComponentScan  //组件扫描
@EnableAutoConfiguration*/  //启用自动配置
@EnableConfigurationProperties(MyConfig.class)
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}

