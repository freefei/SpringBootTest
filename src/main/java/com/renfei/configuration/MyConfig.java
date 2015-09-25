package com.renfei.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 使用自定义的properties
 * 最后注意在spring Boot入口类加上@EnableConfigurationProperties
 * Created with IntelliJ IDEA
 * Author: songrenfei
 * Date: 15/9/20
 * Time: 下午9:16
 */
@Data
@ConfigurationProperties(prefix = "my")
public class MyConfig {
    private String name;
    private Integer age;
}
