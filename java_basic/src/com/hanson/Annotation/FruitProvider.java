package com.hanson.Annotation;

//1.定义一个接口注解
import java.lang.annotation.*;

/**
 * @author 黄忠
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {
    //供应商编号
    public int id() default -1;
    //供应商名称
    public String name() default "";
    //供应商地址
    public String address() default "";
}
