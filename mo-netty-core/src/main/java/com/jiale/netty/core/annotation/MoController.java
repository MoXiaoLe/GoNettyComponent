package com.jiale.netty.core.annotation;


import java.lang.annotation.*;

/**
 * 
 * @author mojiale66@163.com
 * @date 2018年9月27日
 * @description 类似于 spring mvc 的controller 注解
 * 
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MoController {

	String value() default "";
	
}
