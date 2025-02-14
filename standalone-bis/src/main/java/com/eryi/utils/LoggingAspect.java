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
            // 执行额外的动作
            performExtraAction(message);
        }
    }

    @After("execution(* org.slf4j.Logger.error(..))")
    public void afterError(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        if (args.length > 0 && args[0] instanceof String) {
            String message = (String) args[0];
            aspectLogger.error("Error Log Intercepted: {}", message);
            // 执行额外的动作
            performExtraAction(message);
        }
    }

    private void performExtraAction(String message) {
        // 在这里执行额外的动作
        System.out.println("Performing extra action for message: " + message);
        // 例如，发送通知、记录到其他系统等
    }
}
