package com.joshua.easypass.service;

import com.joshua.easypass.entity.Presale;
import com.joshua.easypass.repository.PresaleRepository;
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
public class PresaleService {
    public final static Logger logger = LoggerFactory.getLogger(PresaleService.class);

    @Autowired
    private PresaleRepository pRepo;

    public void delPresale(Integer saleid){
        pRepo.delPresale(saleid);
    }

    public Presale[] getPresales(String vdraddr1, String vdraddr2, String vdraddr3, String vdrplate1, String vdrplate2, String cusmode, String cusname, String state, String itemlist) {

        List<Presale> resultList = null;

        Specification<Presale> querySpecifi = new Specification<Presale>() {

            private static final long serialVersionUID = 1L;
            String addr = vdraddr1 + ("".equals(vdraddr2) ? "" : (" " + vdraddr2)) + ("".equals(vdraddr3) ? "" : (" " + vdraddr3));
            String vdrplate = vdrplate1 + ("".equals(vdrplate2) ? "" : (" " + vdrplate2));
            String[] a = DataUtil.VdrSearchTrim(itemlist.split(","));

            @Override
            public Predicate toPredicate(Root<Presale> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotBlank(addr)) {
                    predicates.add(criteriaBuilder.like(root.get("vdraddr"), "%" + addr + "%"));
                }
                if (StringUtils.isNotBlank(vdrplate)) {
                    predicates.add(criteriaBuilder.like(root.get("vdrplate"), "%" + vdrplate + "%"));
                }
                if (StringUtils.isNotBlank(cusmode)) {
                    predicates.add(criteriaBuilder.like(root.get("cusmode"), "%" + cusmode + "%"));
                }
                if (StringUtils.isNotBlank(cusname)) {
                    predicates.add(criteriaBuilder.like(root.get("cusname"), "%" + cusname + "%"));
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
        resultList = this.pRepo.findAll(querySpecifi);
        if (resultList != null && !resultList.isEmpty()) {
            return resultList.toArray(new Presale[]{});
        }
        return null;
    }

    public Integer createPresale(String creator) {
        Presale p = new Presale();
        p.setCreatedate(new Date());
        p.setCreator(creator);
        p.setState("未录入");
        p = pRepo.saveAndFlush(p);
        return p.getSaleid();
    }

    public void savePresale(Presale v) {
        pRepo.save(v);
    }

    public Presale getPresale(Integer saleid) {
        return pRepo.getPresale(saleid);
    }


//    public Presale[] getPresales(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String state,
//                                       String i1, String i2, String i3, String i4, String i5, String i6, String i7, String i8, String i9, String i10){
//        String addr = s1+ ("".equals(s2)?"":(" "+s2)) + ("".equals(s3)?"":(" "+s3));
//        String vdrplate = s4+("".equals(s5)?"":(" "+s5));
//        return pRepo.getPresale(addr,vdrplate,s6,s7,state,i1,i2,i3,i4,i5,i6,i7,i8,i9,i10);
//    }

}
