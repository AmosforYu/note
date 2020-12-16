package com.yyb.common.annotations;

import com.yyb.common.dtos.error.GlobalControllerAdvice;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Yamos
 * @description EnableControllerAdvice 在项目启动类或配置类
 * @date 2020/12/16 0016 14:11
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(GlobalControllerAdvice.class)
public @interface EnableControllerAdvice {

}
