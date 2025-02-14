package com.eryi.utils;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger aspectLogger = LoggerFactory.getLogger(LoggingAspect.class);

    @After("execution(* org.slf4j.Logger.info(..))")
    public void afterInfo(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        if (args.length > 0 && args[0] instanceof String) {
            String message = (String) args[0];
            aspectLogger.info("Info Log Intercepted: {}", message);
            // ִ�ж���Ķ���
            performExtraAction(message);
        }
    }

    @After("execution(* org.slf4j.Logger.error(..))")
    public void afterError(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        if (args.length > 0 && args[0] instanceof String) {
            String message = (String) args[0];
            aspectLogger.error("Error Log Intercepted: {}", message);
            // ִ�ж���Ķ���
            performExtraAction(message);
        }
    }

    private void performExtraAction(String message) {
        // ������ִ�ж���Ķ���
        System.out.println("Performing extra action for message: " + message);
        // ���磬����֪ͨ����¼������ϵͳ��
    }
}
