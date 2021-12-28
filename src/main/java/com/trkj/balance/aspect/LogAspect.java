//package com.trkj.balance.aspect;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.springframework.stereotype.Component;
//
//// @Aspect 切面的配置
//// @Component 注解配置AOP 【零配置】
//@Slf4j
//@Aspect
//@Component
//public class LogAspect {
//    // 切入点配置 【@Pointcut】
//    @Pointcut(value = "execution(* com.trkj.service..*.*(..))")
//    public void pointcut(){}
//
//    //@Before 前置通知
//    @Before(value = "pointcut()")
//    public void beforeAdvice(JoinPoint joinPoint){
//        log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>即将进入到{}类的{}方法",
//                joinPoint.getTarget().getClass().getName(),
//                joinPoint.getSignature());
//    }
//
//    //@After 后置通知
//    @After(value = "pointcut()")
//    public void afterAdvice(JoinPoint joinPoint){
//        log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<完成{}类的{}方法的执行",
//                joinPoint.getTarget().getClass().getName(),
//                joinPoint.getSignature());
//    }
//
//    //@Around 环绕通知
//    @Around(value = "pointcut()")
//    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
//        log.debug("开始环绕");
//        Object obj=joinPoint.proceed();
//        log.debug("完成环绕");
//        return obj;
//    }
//}
