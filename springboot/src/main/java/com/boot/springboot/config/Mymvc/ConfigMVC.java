package com.boot.springboot.config.Mymvc;

import com.boot.springboot.component.LoginHandlerInterceptor;
import com.boot.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class ConfigMVC implements WebMvcConfigurer {

    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){//拓展springMVC的配置
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) { //视图解析
                registry.addViewController("/").setViewName("Login");
                registry.addViewController("/main").setViewName("main");
            }
            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**") //拦截所有请求
                        .excludePathPatterns("/","/Login","/LoginMain"); //排除无需拦截的请求
            }
        };
        return adapter;
    }

    //加入spring容器，国际化链接处理的
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver(); //注册到容器中
    }

}
