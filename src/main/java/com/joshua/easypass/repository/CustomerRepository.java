package com.joshua.easypass.repository;

import com.joshua.easypass.entity.Customer;
import com.joshua.easypass.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;

public interface CustomerRepository extends JpaRepository<Customer, Integer> ,JpaSpecificationExecutor<Customer>{
    @Query("SELECT c FROM Customer c")
    public Customer[] getAllCustomers();

    @Query("SELECT c FROM Customer c WHERE c.cusmode = :cusmode")
    public Customer[] getCustomersByMode(@Param("cusmode") String cusmode);

    @Query("SELECT c FROM Customer c WHERE c.cusid = :cusid")
    public Customer getCustomer(@Param("cusid") Integer cusid);

    @Query("SELECT c FROM Customer c WHERE c.cusname like %:cusname% AND c.cusmode like %:cusmode% AND c.contact like %:contact% AND c.contactPhone like %:contactPhone% AND c.state like %:state%")
    public Customer[] getCustomers(@Param("cusname") String cusname, @Param("cusmode") String cusmode, @Param("contact") String contact, @Param("contactPhone") String contactPhone, @Param("state") String state);
}
