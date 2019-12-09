package com.bgg.springcloud.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

//抑制警告
@SuppressWarnings("serial")
//@AllArgsConstructor //全参构造
@NoArgsConstructor//无参构造
@Data//一站式解决,注解在类上, 为类提供读写属性, 此外还提供了 equals()、hashCode()、toString() 方法
@Accessors(chain = true)//开起来链式风格,产生的setter返回的this而不是void

public class Dept implements Serializable {//序列化接口
    private Long deptno;
    private String dname;
    private String db_source;//来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库

    public Dept(String dname){
        super();
        this.dname = dname;
    }
}
