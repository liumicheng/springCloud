package com.example.consumer.cfgbeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
/*

我们都知道springboot的这个原理@SpringBootApplication = @Configuration + @EnableAutoConfiguration + @ComponentScan

那么这三个注释代表什么意思？@Configuration 和 @EnableAutoConfiguration都有配置，有什么区别？

@EnableAutoConfiguration：启用Spring Boot的自动配置机制，类似在java代码中自动import，属于自动导入。

这是告诉Spring Boot根据你添加的jar依赖关系“猜测”你想要如何配置Spring。如果你在pom.xml中配置了依赖spring-boot-starter-web,那么其jar包会加入到类路径classpath，spring会自动配置Tomcat和Spring MVC。

自动配置spring mvc是什么意思？如果不是自动配置，我们需要手工配置如下:

    <servlet>
        <servlet-name>dispatcher</servlet-name>
        <servlet-class>
            org.springframework.web.servlet.DispatcherServlet
        </servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>/WEB-INF/todo-servlet.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>

    <servlet-mapping>
        <servlet-name>dispatcher</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
<p>
当我们使用Hibernate / JPA时，我们还需要配置数据源，实体管理器工厂，事务管理器等。

使用自动配置以后，就不需要手工配置了。

@Configuration：有自动导入就有属于自动导出，需要配合该类中方法的@bean，这就相当于一个xml配置:

<beans>
 <bean id="b" class="springsimple.B"/>
 <bean id="a" class="springsimple.A"/>
</beans>
<p>
@bean等于一行bean配置，整个

Xml配置文件等于@Configuration注释的类，spring已经从xml配置为主模式转变到类注释为主的代码模式，估计以后走向函数式方式。

上面这份配置中的A和B类型如果被其他地方需要，比如在其他某处有:

public class C{
   @Autowire
    private A a;

}
<p>
那么在C类就可以使用你提供的A类型了，所以说是导出作用，提供bean源。

@ComponentScan：扫描所有使用@Component 的类，不管自动导入还是导出，首先需要告诉spring boot到哪里去找导入导出的原料。

@SpringBootApplication注解相当于使用@Configuration，@EnableAutoConfiguration以及@ComponentScan 与他们的默认属性。




 */

@Configuration
public class ConfigBean {
//    @LoadBalanced //这里报错
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
