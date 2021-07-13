package com.hanson.Annotation;

import java.lang.reflect.Field;

/**
 * @author 黄忠
 */
public class FruitInfoUtil {
    public static void getFruitInfo(Class < ? > clazz){
        String strFruitProvicer = "供应商信息：";
        Field[] fileds = clazz.getDeclaredFields();//通过反射来获取处理注解
        for (Field filed : fileds) {
            if(filed.isAnnotationPresent(FruitProvider.class)){
                 FruitProvider fruitProvider = (FruitProvider) filed.getAnnotation(FruitProvider.class);
                 //处理注解信息
                strFruitProvicer = "供应商："+fruitProvider.id()+"供应商名称："+fruitProvider.name()+"供应商地址："+fruitProvider.address();
                System.out.println(strFruitProvicer);
            }
        }
    }

}

