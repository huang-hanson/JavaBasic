package com.hanson.framework.protocol.http;

import com.hanson.framework.protocol.register.LocalRegister;
import com.hanson.framework.util.Invocation;
import sun.misc.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 黄忠
 */
public class HttpServerHandler {

    public void handler(HttpServletRequest req, HttpServletResponse resp){

        try {
            Invocation invocation = (Invocation) new ObjectInputStream(req.getInputStream()).readObject();

            Class clazz = LocalRegister.get(invocation.getInterfaceName());

            Method method = clazz.getMethod(invocation.getMethodName(), invocation.getParamType());

            String result = (String) method.invoke(clazz.newInstance(), invocation.getParams());

            IOUtils.write(result,resp.getOutputStream());


        } catch (IOException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (NoSuchMethodException e){
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
