package com.joshua.easypass.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joshua.easypass.entity.AccessLog;
import com.joshua.easypass.repository.AccessLogRepository;

@Service
public class AccessLogService {

    @Autowired
    private AccessLogRepository accessLogRepository;
    
    @Transactional
    public void saveAccessLog(AccessLog accessLog) {
    	accessLogRepository.save(accessLog);
    }
    
    @Transactional
	public void batchLog(List<AccessLog> accessDtos) {
    	accessLogRepository.saveAll(accessDtos);
	}
}
