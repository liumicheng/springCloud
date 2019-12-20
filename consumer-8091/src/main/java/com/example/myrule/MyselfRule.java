package com.example.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 这个类不要放在@ComponentScan所扫描的包或子包下，
 * 否者我们自定义的配资类就会被所有的Ribbon客户端共享，达不到自定义定制的效果了
 */
@Configuration
public class MyselfRule {
    @Bean
    public IRule myRule(){
        return new RoundRobinRule(); //模拟一下  没真的自定义
    }
}
