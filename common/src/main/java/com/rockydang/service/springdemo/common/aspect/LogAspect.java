package com.rockydang.service.springdemo.common.aspect;

import com.rockydang.service.springdemo.common.annotation.uselog.UseLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * Creator: qiaoyu
 * Desc: 用户操作日志Aspect
 * Date: 15/12/11
 */
@Aspect
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("@annotation(com.rockydang.service.springdemo.common.annotation.uselog.UseLog)")
    public void logPointcut() {
    }

    /**
     * Around通知
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("logPointcut()")
    public void doSurround(JoinPoint joinPoint) throws Throwable {
        this.handleLog(joinPoint, null);
    }

    /**
     * Around通知
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Before("logPointcut()")
    public void doHttpLog(JoinPoint joinPoint) throws Throwable {
        this.handleLog(joinPoint, null);
    }

    /**
     * 异常通知
     */
    @AfterThrowing(pointcut = "logPointcut()", throwing = "e")
    public void doHttpException(JoinPoint joinPoint, Throwable e) {
        this.handleLog(joinPoint, e);
    }

    /**
     * 处理日志
     *
     * @param joinPoint
     * @param e
     */
    private void handleLog(JoinPoint joinPoint, Throwable e) {
        try {
            UseLog useLog = this.getUseLogAnno(joinPoint);
            if (useLog == null) {
                return;
            }

            System.out.println("useLog-->"+useLog.title());


        } catch (Exception exp) {
            logger.error("logging uesr operation log failed:{}", exp.getMessage());
        }
    }

    /**
     * 获取UseLog Anno
     *
     * @param joinPoint
     * @return
     * @throws Exception
     */
    private UseLog getUseLogAnno(JoinPoint joinPoint) throws Exception {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if (method != null) {
            return method.getAnnotation(UseLog.class);
        }
        return null;
    }
}
