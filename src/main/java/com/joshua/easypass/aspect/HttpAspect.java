package com.joshua.easypass.aspect;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.joshua.easypass.entity.AccessLog;
import com.joshua.easypass.holder.SessionContextHolder;
import com.joshua.easypass.util.IpUtils;

import net.sf.json.util.JSONUtils;

@Aspect
@Component
public class HttpAspect {
    // slf4j spring自带的log框架
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    
    private  AccessLogQueue accessLogQueue;  

    @Pointcut("execution(public * com.joshua.easypass.controller.business.*.*(..))")
    public void log(){

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        // url
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        AccessLog accessLog = new AccessLog();
        logger.info("url={}",request.getRequestURL());
        accessLog.setUrl(request.getRequestURL().toString());
        // method
        logger.info("method={}",request.getMethod());
        accessLog.setMethod(request.getMethod());
        // ip
        logger.info("ip={}",IpUtils.getIpAddr(request));
        accessLog.setIp(IpUtils.getIpAddr(request));
        // 目标方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        accessLog.setClassMethod(joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        // 记录参数
        //获取用户请求方法的参数并序列化为JSON格式字符串      
        String params = "";      
         if (joinPoint.getArgs() !=  null && joinPoint.getArgs().length > 0) {      
             for ( int i = 0; i < joinPoint.getArgs().length; i++) {      
                params += JSONUtils.valueToString(joinPoint.getArgs()[i]) + ";";      
            }      
        }
        logger.info("args={}",params);
        accessLog.setArgs(params);
        // 记录登录用户
        logger.info("operatorId={}",SessionContextHolder.getCurrentUserSessionStorage().getUserId());
        accessLog.setOperatorId(SessionContextHolder.getCurrentUserSessionStorage().getUserId());
        // 记录当前登录用户名
        logger.info("username={}",SessionContextHolder.getCurrentUserSessionStorage().getUserName());
        accessLog.setUsername(SessionContextHolder.getCurrentUserSessionStorage().getUserName());
        accessLog.setOperatorTime(new Date());
        accessLogQueue.add(accessLog);
    }

    @After("log()")
    public void doAfter(){
        // 获取返回的值
    }

    @AfterReturning(returning="object",pointcut="log()")
    public void doAfterReturning(Object object){
//        logger.info("response={}", object.toString());
    } 
    
    @Resource  
    public void setAccessLogQueue(AccessLogQueue accessLogQueue) {  
        this.accessLogQueue = accessLogQueue;  
    }
}
