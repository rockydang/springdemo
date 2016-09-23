package com.rockydang.service.springdemo.common.annotation.uselog;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Creator: qiaoyu
 * Desc: 用户操作纪录annotation
 * Date： 2015-12-11 14:30
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UseLog {
    /**
     * 日志记录标题
     * @return
     */
    String title() default "";

    /**
     * 操作
     * @return
     */
    String action() default "";

    /**
     * 是否记录请求参数
     * @return
     */
    boolean isSaveRequestData() default false;
}
