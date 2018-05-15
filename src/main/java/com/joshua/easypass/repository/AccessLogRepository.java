package com.joshua.easypass.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joshua.easypass.entity.AccessLog;

public interface AccessLogRepository extends JpaRepository<AccessLog, Long> {

}
