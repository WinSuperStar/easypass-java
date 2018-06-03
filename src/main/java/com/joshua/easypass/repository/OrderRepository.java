package com.joshua.easypass.repository;

import com.joshua.easypass.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<Order, Integer>, JpaSpecificationExecutor<Order> {
    @Modifying
    @Query(value="UPDATE Order o SET o.state = :state WHERE o.orderid = :orderid", nativeQuery = true)
    public Order updateOdr(@Param("orderid") Integer orderid, @Param("state") String state);

    @Query("SELECT v FROM Order v WHERE v.orderid = :orderid")
    public Order getOdr(@Param("orderid") Integer orderid);
}
