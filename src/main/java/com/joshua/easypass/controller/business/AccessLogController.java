package com.joshua.easypass.controller.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joshua.easypass.encap.DataTableResult;
import com.joshua.easypass.encap.DateTableParameter;
import com.joshua.easypass.entity.AccessLog;
import com.joshua.easypass.service.AccessLogService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class AccessLogController {

	
    @Autowired
    private AccessLogService accessLogService;
    
    @PostMapping(value = "/accessLogs")
    public DataTableResult<AccessLog> queryAccessLogPage(DateTableParameter dateTableParameter) {
    	DataTableResult<AccessLog>  dataTableResult = new DataTableResult<AccessLog>();
    	Page<AccessLog> dbPageData = accessLogService.queryAccessLogPage(null,dateTableParameter.currentPageIndex(), dateTableParameter.getLength());
    	dataTableResult.setDraw(dateTableParameter.getDraw());
    	dataTableResult.setData(dbPageData.getContent());
    	dataTableResult.setRecordsFiltered(dbPageData.getTotalElements());
    	dataTableResult.setRecordsTotal(dbPageData.getTotalElements());
        return dataTableResult;
    }
}
