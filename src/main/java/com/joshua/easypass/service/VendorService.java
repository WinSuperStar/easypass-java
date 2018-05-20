package com.joshua.easypass.service;

import com.joshua.easypass.entity.Authlist;
import com.joshua.easypass.entity.Vendor;
import com.joshua.easypass.repository.AuthlistRepository;
import com.joshua.easypass.repository.VendorRepository;
import com.joshua.easypass.util.DataUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VendorService {
    public final static Logger logger = LoggerFactory.getLogger(VendorService.class);

    @Autowired
    private VendorRepository vdrRepo;

    public Vendor[] getAllVdrs(){
        return vdrRepo.getAllVdrs();
    }

    public Vendor[] getVdrsWithoutDate(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String state,
                            String i1, String i2, String i3, String i4, String i5, String i6, String i7, String i8, String i9, String i10){
        String addr = s1+ ("".equals(s2)?"":(" "+s2)) + ("".equals(s3)?"":(" "+s3));
        String vdrplate = s4+("".equals(s5)?"":(" "+s5));
        logger.info("vendor查询， 条件地址为"+addr+"，条件牌照为："+vdrplate);
        logger.info("其他查询条件："+state+" "+i1+" "+i2);
        return vdrRepo.getVdrsWithoutDate(addr,vdrplate,s6,s7,state,i1,i2,i3,i4,i5,i6,i7,i8,i9,i10);
    }

    public Vendor[] getVdrsWithDate(String s1, String s2, String s3, String s4, String s5, String s6, String s7, Date d1, Date d2, String state,
                            String i1, String i2, String i3, String i4, String i5, String i6, String i7, String i8, String i9, String i10){
        String addr = s1+ ("".equals(s2)?"":(" "+s2)) + ("".equals(s3)?"":(" "+s3));
        String vdrplate = s4+("".equals(s5)?"":(" "+s5));
        return vdrRepo.getVdrsWithDate(addr,vdrplate,s6,s7,d1,d2,state,i1,i2,i3,i4,i5,i6,i7,i8,i9,i10);
    }

    public Integer createVdr(String creator) {
        Vendor v = new Vendor();
        v.setCreatedate(new Date());
        v.setCreator(creator);
        v.setState("未提交");
        v = vdrRepo.saveAndFlush(v);
        return v.getVdrid();
    }

    public void saveVdr(Vendor v){
        vdrRepo.save(v);
    }

    public Vendor getVdr(Integer vdrid){
        return vdrRepo.getVdr(vdrid);
    }
}