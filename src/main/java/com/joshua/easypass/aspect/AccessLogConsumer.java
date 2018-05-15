package com.joshua.easypass.aspect;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.joshua.easypass.entity.AccessLog;
import com.joshua.easypass.service.AccessLogService;

@Component
public class AccessLogConsumer  implements Runnable {
	
	private static Logger logger = LoggerFactory.getLogger(AccessLogConsumer.class);  

    public static final int DEFAULT_BATCH_SIZE = 64;  
    private AccessLogQueue accessLogQueue;  
    private AccessLogService accessLogService;  
    private int batchSize = DEFAULT_BATCH_SIZE;  
    private boolean active = true;  
    private Thread thread;  
      
    @PostConstruct  
    public void init() {  
        thread = new Thread(this);  
        thread.start();  
    }  
  
    @PreDestroy  
    public void close() {  
        active = false;  
    }  
  
    public void run() {  
        while (active) {  
            execute();  
        }  
    }  
    
    public void execute() {  
        List<AccessLog> accessDtos = new ArrayList<AccessLog>();  
        try {  
            int size = 0;  
            while (size < batchSize) {  
            	AccessLog accessLog = accessLogQueue.poll();  
                if (accessLog == null) {  
                    break;  
                }  
                accessDtos.add(accessLog);  
                size++;  
            }  
        } catch (Exception ex) {  
            logger.info(ex.getMessage(), ex);  
        }  
        if (!accessDtos.isEmpty()) {  
        	accessLogService.batchLog(accessDtos);  
        }  
    }  
    
    @Resource  
    public void setAccessLogQueue(AccessLogQueue accessLogQueue) {  
        this.accessLogQueue = accessLogQueue;  
    }
    
    @Resource  
    public void setAccessLogService(AccessLogService accessLogService) {  
        this.accessLogService = accessLogService;  
    }  
  
    public void setBatchSize(int batchSize) {  
        this.batchSize = batchSize;  
    }  
}
