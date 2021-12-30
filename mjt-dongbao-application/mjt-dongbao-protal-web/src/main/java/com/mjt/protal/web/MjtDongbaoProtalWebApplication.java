package com.mjt.protal.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * @Description
 * @Author mjt
 * @Time 2021/12/29
 */

/**
 * scanBasePackages 作用：如果不加这个属性，就会只扫描启动类所在包下面的注解，
 *                       在多模块的情况下，就无法扫描其它模块的注解
 * @MapperScam 注解：此注解一定要精确到 XXMapper 接口所在的包
 */
@SpringBootApplication(scanBasePackages = {"com.mjt"})
@MapperScan("com.mjt.dongbao.ums.mapper")
public class MjtDongbaoProtalWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MjtDongbaoProtalWebApplication.class, args);
    }

    @Bean
    public PasswordEncoder passWordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
