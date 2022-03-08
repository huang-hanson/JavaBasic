package com.hanson.provider;

import com.hanson.framework.protocol.http.HttpService;
import com.hanson.framework.protocol.register.LocalRegister;
import com.hanson.provider.api.HelloService;
import com.hanson.provider.impl.HelloServiceImpl;

/**
 * @author 黄忠
 */
public class Provider {
    //1.RPC调用与传统HTTP调用的区别？
    //2.Dubbo基本的用法
    //3.Dubbo的服务暴露基本原则
    //4.Dubbo的服务注册基本原理
    //5.Dubbo的服务调用的基本原理
    //6.Dubbo的服务容错的基本原理
    //7.Dubbo的服务重试的基本原理
    public static void main(String[] args) {
        //Tomcat Jetty  netty

        LocalRegister.register(HelloService.class.getName(), HelloServiceImpl.class);

        HttpService httpService = new HttpService();
        httpService.start("localhost",8080);
    }
}
