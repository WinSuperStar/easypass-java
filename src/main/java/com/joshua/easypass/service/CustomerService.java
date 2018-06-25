package com.joshua.easypass.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.joshua.easypass.entity.Customer;
import com.joshua.easypass.repository.CustomerRepository;

@Service
public class CustomerService {
    public final static Logger logger = LoggerFactory.getLogger(CustomerService.class);
    @Autowired
    private CustomerRepository cusRepo;

    public Customer[] getCustomersByMode(String cusmode) {
        return cusRepo.getCustomersByMode(cusmode);
    }

    public Customer[] getAllCustomers() {
        return cusRepo.getAllCustomers();
    }

    public Customer getCustomer(Integer cusid) {
        return cusRepo.getCustomer(cusid);
    }

    public Customer[] getCustomers(String cusname, String cusmode, String contact, String contactPhone, String state) {
        logger.info("查询中：客户名为{},客户模式为{}, 联系人为{}, 联系人电话为{}, 状态为{}", cusname, cusmode, contact, contactPhone, state);
        return cusRepo.getCustomers(cusname, cusmode, contact, contactPhone, state);
    }

    @Transactional
    public void updateCus(Customer cus){
        Customer cusToUpdate = cusRepo.getOne(cus.getCusid());
        cus.setCreatedate(cusToUpdate.getCreatedate());
        cus.setCreator(cusToUpdate.getCreator());
        cusRepo.save(cus);
    }


    @Transactional
    public void addCus(Customer cus) {
//        cusRepo.
        cusRepo.save(cus);
    }
    
   /* public Page<Customer> queryCustomerPage(Customer cus,int currentPageIndex, int pageSize) {
		Sort sort = new Sort(Sort.Direction.DESC,"cusid");
		Pageable pageable = PageRequest.of(currentPageIndex,pageSize,sort);
    	return cusRepo.findAll(pageable);
	}    */


    public Page<Customer> queryCusPage(Customer cus, int currentPageIndex, int pageSize) {
        Specification<Customer> querySpecifi = new Specification<Customer>() {

            private static final long serialVersionUID = 1L;

            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotBlank(cus.getCusname())) {
                    predicates.add(criteriaBuilder.like(root.get("cusname"), "%" + cus.getCusname() + "%"));
                }
                if (StringUtils.isNotBlank(cus.getCusmode())) {
                    predicates.add(criteriaBuilder.like(root.get("cusmode"), "%" + cus.getCusmode() + "%"));
                }
                if (StringUtils.isNotBlank(cus.getContact())) {
                    predicates.add(criteriaBuilder.equal(root.get("contact"), cus.getContact()));
                }
                if (StringUtils.isNotBlank(cus.getState())) {
                    predicates.add(criteriaBuilder.like(root.get("state"), "%" + cus.getState() + "%"));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        Sort sort = new Sort(Sort.Direction.DESC, "cusid");
        Pageable pageable = PageRequest.of(currentPageIndex, pageSize, sort);
        return cusRepo.findAll(querySpecifi, pageable);
    }
}
