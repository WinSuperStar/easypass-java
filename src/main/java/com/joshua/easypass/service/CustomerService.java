package com.joshua.easypass.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.joshua.easypass.entity.Customer;
import com.joshua.easypass.repository.CustomerRepository;

@Service
public class CustomerService {
    public final static Logger logger = LoggerFactory.getLogger(CustomerService.class);
    @Autowired
    private CustomerRepository cusRepo;

    public Customer[] getCustomersByMode(String cusmode){return cusRepo.getCustomersByMode(cusmode);}

    public Customer[] getAllCustomers() {
        return cusRepo.getAllCustomers();
    }

    public Customer getCustomer(Integer cusid){
        return cusRepo.getCustomer(cusid);
    }

    public Customer[] getCustomers(String cusname, String cusmode, String contact, String contactPhone, String state) {
        logger.info("查询中：客户名为{},客户模式为{}, 联系人为{}, 联系人电话为{}, 状态为{}", cusname, cusmode, contact, contactPhone, state);
        return cusRepo.getCustomers(cusname, cusmode, contact, contactPhone, state);
    }

    @Transactional
    public void addCus(Customer cus) {
        cusRepo.save(cus);
    }
    
    public Page<Customer> queryCustomerPage(Customer cus,int currentPageIndex, int pageSize) {
		Sort sort = new Sort(Sort.Direction.DESC,"cusid");
		Pageable pageable = PageRequest.of(currentPageIndex,pageSize,sort);
    	return cusRepo.findAll(pageable);
	}    
}
