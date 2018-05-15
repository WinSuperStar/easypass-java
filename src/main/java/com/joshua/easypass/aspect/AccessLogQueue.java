package com.joshua.easypass.aspect;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.joshua.easypass.entity.AccessLog;

@Component 
public class AccessLogQueue {

    private BlockingQueue<AccessLog> blockingQueue = new LinkedBlockingQueue<AccessLog>();  
    
    public void add(AccessLog accessLog) {  
        blockingQueue.add(accessLog);  
    }  
  
    public AccessLog poll() throws InterruptedException {  
        return blockingQueue.poll(1, TimeUnit.SECONDS);  
    }  
}
