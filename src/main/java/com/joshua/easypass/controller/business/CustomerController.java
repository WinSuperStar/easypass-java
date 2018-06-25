package com.joshua.easypass.controller.business;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joshua.easypass.encap.DataTableResult;
import com.joshua.easypass.encap.DateTableParameter;
import com.joshua.easypass.entity.Customer;
import com.joshua.easypass.service.CustomerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class CustomerController {
    public final static Logger logger = LoggerFactory.getLogger(RoleController.class);
    @Autowired
    private CustomerService cusService;

    @GetMapping(value = "/allCustomers")
    public Customer[] getAllCustomers() {
        return cusService.getAllCustomers();
    }

    @PostMapping(value = "/customersByMode")
    public Customer[] getCustomersByMode(@RequestParam("cusmode") String cusmode) {
        return cusService.getCustomersByMode(cusmode);
    }

    @GetMapping(value = "/customer/{id}")
    public Customer getCustomer(@PathVariable("id") Integer id) {
        return cusService.getCustomer(id);
    }

    @PutMapping(value = "/customer")
    public void updateCus(@RequestParam("cusid") Integer cusid,
                          @RequestParam("cusname") String cusname,
                          @RequestParam("contact") String contact,
                          @RequestParam("contactPhone") String contactPhone,
                          @RequestParam("cusmode") String cusmode,
                          @RequestParam("address") String address,
                          @RequestParam("state") String state,
                          @RequestParam("createdate") String createdate,
                          @RequestParam("creator") String creator,
                          @RequestParam("add1") String add1) {
//        Date currentTime = new Date();
        Customer cus = new Customer();
        cus.setCusid(cusid);
        cus.setCusname(cusname);
        cus.setContact(contact);
        cus.setContactPhone(contactPhone);
        cus.setCusmode(cusmode);
        cus.setAddress(address);
        cus.setState(state);
//        cus.setCreatedate(currentTime);
//        cus.setCreator(creator);
        cus.setAdd1(add1);
        logger.info("更新客户：" + cus.toString());
        cusService.updateCus(cus);
    }

    @PostMapping(value = "/customers")
    public Customer[] getCus(@RequestParam("cusname") String cusname,
                             @RequestParam("cusmode") String cusmode,
                             @RequestParam("contact") String contact,
                             @RequestParam("contactPhone") String contactPhone,
                             @RequestParam("state") String state
    ) {
        return cusService.getCustomers(cusname, cusmode, contact, contactPhone, state);
    }

    @PostMapping(value = "/addCus")
    public void addCus(@RequestParam("cusname") String cusname,
                       @RequestParam("contact") String contact,
                       @RequestParam("contactPhone") String contactPhone,
                       @RequestParam("cusmode") String cusmode,
                       @RequestParam("address") String address,
                       @RequestParam("state") String state,
                       @RequestParam("creator") String creator,
                       @RequestParam("add1") String add1) {
        Date currentTime = new Date();
        Customer cus = new Customer();
        cus.setCusname(cusname);
        cus.setContact(contact);
        cus.setContactPhone(contactPhone);
        cus.setCusmode(cusmode);
        cus.setAddress(address);
        cus.setState(state);
        cus.setCreatedate(currentTime);
        cus.setCreator(creator);
        cus.setAdd1(add1);
        logger.info("新建客户：" + cus.toString());
        cusService.addCus(cus);
    }
}
