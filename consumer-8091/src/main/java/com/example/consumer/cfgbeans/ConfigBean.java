package com.example.consumer.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced //spring cloud Ribbon 是基于Netflix Ribbon实现的一套  客户端 ——负载均衡的工具  该注解要和@Bean搭配使用
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public IRule myRule(){
       // return new RoundRobinRule(); // 默认为此轮询
       // return new RandomRule(); //随机代替轮询
        return new RetryRule(); //先按照轮询，若获取其中某个服务是失败，在指定时间里，会跳过此服务，继续访问其他

    }
}
