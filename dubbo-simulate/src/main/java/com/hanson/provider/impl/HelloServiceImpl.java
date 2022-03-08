package com.hanson.provider.impl;

import com.hanson.provider.api.HelloService;

/**
 * @author 黄忠
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String userName){
        return "Hello: "+userName;
    }
}
