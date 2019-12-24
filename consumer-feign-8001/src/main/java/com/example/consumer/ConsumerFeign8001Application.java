package com.example.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import sun.net.www.content.text.plain;

@SpringBootApplication
@EnableEurekaClient
//com.bgg.springcloud 项目api打的包
@EnableFeignClients(basePackages = {"com.bgg.springcloud"})
/*
feign内部包含了ribbon，所以也有负载均衡的功能，默认也是轮询。


如果@SpringBootApplication和@ComponentScan注解共存，
那么@SpringBootApplication注解的扫描的作用将会失效，
也就是说不能够扫描启动类所在包以及子包了。
因此，我们必须在@ComponentScan注解配置本工程需要扫描的包范围
 */
@ComponentScan(basePackages = {"com.bgg.springcloud","com.example.consumer"})
public class ConsumerFeign8001Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeign8001Application.class, args);
    }

}
