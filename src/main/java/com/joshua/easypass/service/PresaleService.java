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
        p = pRepo.saveAndFlush(p);
        return p.getSaleid();
    }

    public void savePresale(Presale v) {
        pRepo.save(v);
    }

    public Presale getPresale(Integer saleid) {
        return pRepo.getPresale(saleid);
    }
}
