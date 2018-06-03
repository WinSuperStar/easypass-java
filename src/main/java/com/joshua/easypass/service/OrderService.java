package com.joshua.easypass.service;

import com.joshua.easypass.entity.Order;
import com.joshua.easypass.repository.OrderRepository;
import com.joshua.easypass.util.DataUtil;
import com.joshua.easypass.util.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    public final static Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderRepository odrRepo;

    public Integer createOdr(String creator) {
        Order order = new Order();
        order.setCreatedate(new Date());
        order.setItemDeadline(DateUtil.autoComDate());
        order.setCreator(creator);
        order.setState("未提交");
        order.setFinanceState("未提交");
        logger.info(order.toString());
        order = odrRepo.saveAndFlush(order);
        return  order.getOrderid();
    }

    public Order getOdr(Integer orderid){
        return odrRepo.getOdr(orderid);
    }

    public void saveOdr(Order order) {
        odrRepo.save(order);
    }

    public Order[] getOdrs(String orderid, String plateCode, String plateNum, String oriOwnerName, String carbrand, String carset, String carnum, String cusname,
                           String kuaidiNum, String state, String itemlist, String creator) {

        List<Order> resultList = null;
        Date date1 = null;
        Date date2 = null;

        Specification<Order> querySpecifi = new Specification<Order>() {

            private static final long serialVersionUID = 1L;
            //            String addr = vdraddr1 + ("".equals(vdraddr2) ? "" : (" " + vdraddr2)) + ("".equals(vdraddr3) ? "" : (" " + vdraddr3));
//            String vdrplate = vdrplate1 + ("".equals(vdrplate2) ? "" : (" " + vdrplate2));
            String[] a = DataUtil.VdrSearchTrim(itemlist.split(","));

            @Override
            public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotBlank(orderid)) {
                    predicates.add(criteriaBuilder.equal(root.get("orderid"), "%" + orderid + "%"));
                }
                if (StringUtils.isNotBlank(plateNum)) {
                    predicates.add(criteriaBuilder.like(root.get("plateNum"), "%" + plateNum + "%"));
                }
                if (StringUtils.isNotBlank(oriOwnerName)) {
                    predicates.add(criteriaBuilder.like(root.get("oriOwnerName"), "%" + oriOwnerName + "%"));
                }
                if (StringUtils.isNotBlank(plateCode)) {
                    predicates.add(criteriaBuilder.like(root.get("plateCode"), "%" + plateCode + "%"));
                }
                if (StringUtils.isNotBlank(carbrand)) {
                    predicates.add(criteriaBuilder.like(root.get("carbrand"), "%" + carbrand + "%"));
                }
                if (StringUtils.isNotBlank(carset)) {
                    predicates.add(criteriaBuilder.like(root.get("carset"), "%" + carset + "%"));
                }
                if (StringUtils.isNotBlank(state)) {
                    predicates.add(criteriaBuilder.like(root.get("state"), "%" + state + "%"));
                }
                if (StringUtils.isNotBlank(itemlist)) {
                    predicates.add(criteriaBuilder.like(root.get("state"), "%" + state + "%"));
                }
                if (StringUtils.isNotBlank(carnum)) {
                    predicates.add(criteriaBuilder.like(root.get("carnum"), "%" + carnum + "%"));
                }
                if (StringUtils.isNotBlank(cusname)) {
                    predicates.add(criteriaBuilder.like(root.get("cusname"), "%" + cusname + "%"));
                }
                if (StringUtils.isNotBlank(kuaidiNum)) {
                    predicates.add(criteriaBuilder.like(root.get("kuaidiNum"), "%" + kuaidiNum + "%"));
                }
                if (StringUtils.isNotBlank(a[0].trim())) {
                    predicates.add(criteriaBuilder.equal(root.get("itemTidang"), "%" + a[0] + "%"));
                }
                if (StringUtils.isNotBlank(a[1].trim())) {
                    predicates.add(criteriaBuilder.equal(root.get("itemGuohu"), "%" + a[1] + "%"));
                }
                if (StringUtils.isNotBlank(a[2].trim())) {
                    predicates.add(criteriaBuilder.equal(root.get("itemShangpai"), "%" + a[2] + "%"));
                }
                if (StringUtils.isNotBlank(a[3].trim())) {
                    predicates.add(criteriaBuilder.equal(root.get("itemWeizhang"), "%" + a[3] + "%"));
                }
                if (StringUtils.isNotBlank(a[4].trim())) {
                    predicates.add(criteriaBuilder.equal(root.get("itemDiya"), "%" + a[4] + "%"));
                }
                if (StringUtils.isNotBlank(a[5].trim())) {
                    predicates.add(criteriaBuilder.equal(root.get("itemJiechudiya"), "%" + a[5] + "%"));
                }
                if (StringUtils.isNotBlank(a[6].trim())) {
                    predicates.add(criteriaBuilder.equal(root.get("itemWeituo"), "%" + a[6] + "%"));
                }
                if (StringUtils.isNotBlank(a[7].trim())) {
                    predicates.add(criteriaBuilder.equal(root.get("itemNianjian"), "%" + a[7] + "%"));
                }
                if (StringUtils.isNotBlank(a[8].trim())) {
                    predicates.add(criteriaBuilder.equal(root.get("itemBuhuan"), "%" + a[8] + "%"));
                }
                if (StringUtils.isNotBlank(a[9].trim())) {
                    predicates.add(criteriaBuilder.equal(root.get("itemQita"), "%" + a[9] + "%"));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        resultList = this.odrRepo.findAll(querySpecifi);
        if (resultList != null && !resultList.isEmpty()) {
            return resultList.toArray(new Order[]{});
        }
        return null;
    }
}
