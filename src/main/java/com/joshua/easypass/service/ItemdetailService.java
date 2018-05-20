package com.joshua.easypass.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joshua.easypass.entity.Itemdetail;
import com.joshua.easypass.repository.ItemdetailRepository;

@Service
public class ItemdetailService {
    public final static Logger logger = LoggerFactory.getLogger(ItemdetailService.class);

    @Autowired
    private ItemdetailRepository idRepo;

    public Integer createItemdetail(Integer billid, String billname, String itemname, String creator, String billtype) {
        Itemdetail i = new Itemdetail();
        i.setCreatedate(new Date());
        i.setCreator(creator);
        i.setRelatedBillId(billid);
        i.setRelatedBillName(billname);
        i.setRelatedItemName(itemname);
        i.setRelatedBillType(billtype);
        i = idRepo.saveAndFlush(i);
        return i.getPapid();
    }

    public Itemdetail getItemdetail(Integer papid){
        return idRepo.getItemdetail(papid);
    }

    public void saveItemdetail(Itemdetail i){
        idRepo.save(i);
    }
}