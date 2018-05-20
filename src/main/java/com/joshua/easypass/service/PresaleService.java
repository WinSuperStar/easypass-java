package com.joshua.easypass.service;

import com.joshua.easypass.entity.Presale;
import com.joshua.easypass.repository.PresaleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PresaleService {
    public final static Logger logger = LoggerFactory.getLogger(PresaleService.class);

    @Autowired
    private PresaleRepository pRepo;

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


    public Presale[] getPresales(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String state,
                                       String i1, String i2, String i3, String i4, String i5, String i6, String i7, String i8, String i9, String i10){
        String addr = s1+ ("".equals(s2)?"":(" "+s2)) + ("".equals(s3)?"":(" "+s3));
        String vdrplate = s4+("".equals(s5)?"":(" "+s5));
        return pRepo.getPresale(addr,vdrplate,s6,s7,state,i1,i2,i3,i4,i5,i6,i7,i8,i9,i10);
    }

}
