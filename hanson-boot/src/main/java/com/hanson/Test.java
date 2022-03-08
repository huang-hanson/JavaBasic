package com.hanson;

import com.hanson.boot.HansonSpringApplication;
import com.hanson.boot.HansonSpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author 黄忠
 */
@HansonSpringBootApplication
public class Test {

    @Bean
    public DispatcherServlet dispatcherServlet(){
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        return dispatcherServlet;
    }

    public static void main(String[] args) {
        HansonSpringApplication.run(Test.class);
    }

}
