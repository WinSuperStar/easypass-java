package com.joshua.easypass.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    
	public Page<AccessLog> queryAccessLogPage(AccessLog accessLog,int currentPageIndex, int pageSize) {
		Sort sort = new Sort(Sort.Direction.DESC,"id");
		Pageable pageable = PageRequest.of(currentPageIndex,pageSize,sort);
    	return accessLogRepository.findAll(pageable);
	}    
}
