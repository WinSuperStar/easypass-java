package com.joshua.easypass.service;

import java.util.ArrayList;
import java.util.Date;
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

import com.joshua.easypass.entity.Vendor;
import com.joshua.easypass.repository.VendorRepository;
import com.joshua.easypass.util.DataUtil;
import com.joshua.easypass.util.DateUtil;

@Service
public class VendorService {
    public final static Logger logger = LoggerFactory.getLogger(VendorService.class);

    @Autowired
    private VendorRepository vdrRepo;
    @Transactional
    public void smtVdr(Integer vdrid){
        vdrRepo.smtVdr(vdrid);
    }
    @Transactional
    public void delVdr(Integer vdrid){
        vdrRepo.delVdr(vdrid);
    }

    public Vendor[] getAllVdrs() {
        return vdrRepo.getAllVdrs();
    }

    public Page<Vendor> queryVdrPage(String vdraddr1, String vdraddr2, String vdraddr3, String vdrplate1, String vdrplate2, String contact, String contactphone, String firstdate, String state, String itemlist,int currentPageIndex, int pageSize) { 

          Specification<Vendor> querySpecifi = new Specification<Vendor>() {

              private static final long serialVersionUID = 1L;
              String addr = vdraddr1 + ("".equals(vdraddr2) ? "" : (" " + vdraddr2)) + ("".equals(vdraddr3) ? "" : (" " + vdraddr3));
              String vdrplate = vdrplate1 + ("".equals(vdrplate2) ? "" : (" " + vdrplate2));
              String[] a = DataUtil.VdrSearchTrim(itemlist.split(","));

              @Override
              public Predicate toPredicate(Root<Vendor> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                  List<Predicate> predicates = new ArrayList<>();
                  if (StringUtils.isNotBlank(addr)) {
                      predicates.add(criteriaBuilder.like(root.get("vdraddr"), "%" + addr + "%"));
                  }
                  if (StringUtils.isNotBlank(vdrplate)) {
                      predicates.add(criteriaBuilder.like(root.get("vdrplate"), "%" + vdrplate + "%"));
                  }
                  if (StringUtils.isNotBlank(contact)) {
                      predicates.add(criteriaBuilder.like(root.get("vdrplate"), "%" + contact + "%"));
                  }
                  if (StringUtils.isNotBlank(contactphone)) {
                      predicates.add(criteriaBuilder.like(root.get("vdrplate"), "%" + contactphone + "%"));
                  }
                  if (StringUtils.isNotBlank(firstdate)) {
                      String[] dates = firstdate.split(" ");
                      Date date1 = DateUtil.StrToDate(dates[0]);
                      Date date2 = DateUtil.StrToDate(dates[1]);
                      predicates.add(criteriaBuilder.greaterThan(root.get("firstdate"), "%" + date1 + "%"));
                      predicates.add(criteriaBuilder.lessThan(root.get("firstdate"), "%" + date2 + "%"));
                  }
                  if (StringUtils.isNotBlank(state)) {
                      predicates.add(criteriaBuilder.like(root.get("state"), "%" + state + "%"));
                  }
                  if (StringUtils.isNotBlank(itemlist)) {
                  
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
                  }
                  return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
              }
          };
          Sort sort = new Sort(Sort.Direction.DESC,"vdrid");
  		  Pageable pageable = PageRequest.of(currentPageIndex,pageSize,sort);
          return vdrRepo.findAll(querySpecifi,pageable);
          
    }
    public Vendor[] getVdrs(String vdraddr1, String vdraddr2, String vdraddr3, String vdrplate1, String vdrplate2, String contact, String contactphone, String firstdate, String state, String itemlist) {
//        logger.info("查询中：用户名为{},手机号码为{}, 岗位为{}, 状态为{}", username, phone, roleid, state);

        List<Vendor> resultList = null;

        Specification<Vendor> querySpecifi = new Specification<Vendor>() {

            private static final long serialVersionUID = 1L;
            String addr = vdraddr1 + ("".equals(vdraddr2) ? "" : (" " + vdraddr2)) + ("".equals(vdraddr3) ? "" : (" " + vdraddr3));
            String vdrplate = vdrplate1 + ("".equals(vdrplate2) ? "" : (" " + vdrplate2));
            String[] a = DataUtil.VdrSearchTrim(itemlist.split(","));

            @Override
            public Predicate toPredicate(Root<Vendor> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotBlank(addr)) {
                    predicates.add(criteriaBuilder.like(root.get("vdraddr"), "%" + addr + "%"));
                }
                if (StringUtils.isNotBlank(vdrplate)) {
                    predicates.add(criteriaBuilder.like(root.get("vdrplate"), "%" + vdrplate + "%"));
                }
                if (StringUtils.isNotBlank(contact)) {
                    predicates.add(criteriaBuilder.like(root.get("vdrplate"), "%" + contact + "%"));
                }
                if (StringUtils.isNotBlank(contactphone)) {
                    predicates.add(criteriaBuilder.like(root.get("vdrplate"), "%" + contactphone + "%"));
                }
                if (StringUtils.isNotBlank(firstdate)) {
                    String[] dates = firstdate.split(" ");
                    Date date1 = DateUtil.StrToDate(dates[0]);
                    Date date2 = DateUtil.StrToDate(dates[1]);
                    predicates.add(criteriaBuilder.greaterThan(root.get("firstdate"), "%" + date1 + "%"));
                    predicates.add(criteriaBuilder.lessThan(root.get("firstdate"), "%" + date2 + "%"));
                }
                if (StringUtils.isNotBlank(state)) {
                    predicates.add(criteriaBuilder.like(root.get("state"), "%" + state + "%"));
                }
                if (StringUtils.isNotBlank(itemlist)) {
                    predicates.add(criteriaBuilder.like(root.get("state"), "%" + state + "%"));
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
        resultList = this.vdrRepo.findAll(querySpecifi);
        if (resultList != null && !resultList.isEmpty()) {
            return resultList.toArray(new Vendor[]{});
        }
        return null;
    }

    public Integer createVdr(String creator) {
        Vendor v = new Vendor();
        v.setCreatedate(new Date());
        v.setCreator(creator);
        v.setState("未提交");
        v = vdrRepo.saveAndFlush(v);
        return v.getVdrid();
    }

    public void saveVdr(Vendor v) {
        vdrRepo.save(v);
    }

    public Vendor getVdr(Integer vdrid) {
        return vdrRepo.getVdr(vdrid);
    }



}