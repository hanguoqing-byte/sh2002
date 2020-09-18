package com.powernode.app;

import java.lang.annotation.*;

/**
 * Company : BJPowernode
 * Date : 2020/9/15
 * Description :
 *
 *  注解：  注解   1.5版本
 *
 * 元注解：定义注解的注解
 * @Documented
 * @Target():决定了注解的作用域
 * ElementType:
 *      TYPE  :类上
 *      METHOD ：方法
 *      PARAMETER ：形参
 *      CONSTRUCTOR ：构造函数
 *      LOCAL_VARIABLE ：局部变量
 *      TYPE_USE ：
 *      MODULE
 *      PACKAGE ：包
 *      ANNOTATION_TYPE
 *      FIELD  ：属性
 *
 *注解的属性是方法的名称，注解的属性值类型是该方法的返回值类型
 * 类型： 8中基本数据类型  不是包装类
 *       String类型
 *       枚举类型
 *
 *       如果给定的是基本数据类型或者是String的类型请指定一个默认的属性值。模具类型不需要
 *
 *
 */
@Documented
@Inherited
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {

     String value() default "";

     boolean isPk() default false;

     boolean isInsert() default true;

     /*ResultEnum result() default ;*/

}
