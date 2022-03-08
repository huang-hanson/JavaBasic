package com.hanson.boot;

import org.apache.catalina.*;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author 黄忠
 */
public class HansonSpringApplication {

    public static ConfigurableApplicationContext run(Class config){
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(config);
        applicationContext.refresh();

        startTomcat(applicationContext);//Tomcat Jetty Undertow  pom.xml(替换依赖)

        return applicationContext;
    }

    private static Tomcat startTomcat(AnnotationConfigWebApplicationContext applicationContext){
        Tomcat tomcat = new Tomcat();

        Server server = tomcat.getServer();
        Service service = server.findService("Tomcat");


        Connector connector = new Connector();
        connector.setPort(8081);

        Engine engine = new StandardEngine();
        engine.setDefaultHost("localhost");

        Host host = new StandardHost();
        host.setName("localhost");

        String contextPath = "";
        Context context = new StandardContext();
        context.setPath(contextPath);
        context.addLifecycleListener(new Tomcat.FixContextListener());

        host.addChild(context);
        engine.addChild(host);

        service.setContainer(engine);
        service.addConnector(connector);



        tomcat.addServlet(contextPath,"dispatcher",applicationContext.getBean(DispatcherServlet.class));
        context.addServletMappingDecoded("/*","dispatcher");

        try {
            tomcat.start();
        }catch (LifecycleException e){
            e.printStackTrace();
        }

        return tomcat;

    }

}
