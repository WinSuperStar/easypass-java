package com.joshua.easypass.controller.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joshua.easypass.entity.Itemdetail;
import com.joshua.easypass.service.ItemdetailService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class ItemdetailController {
    @Autowired
    private ItemdetailService idService;

    @PostMapping(value = "/createItemdetail")
    public Integer createVdr(@RequestParam("vdrid") Integer vdrid,
            @RequestParam("creator") String creator) {
        return idService.createItemdetail(vdrid, creator);
    }

    @PostMapping(value="/getItemdetail")
    public Itemdetail getVdr(@RequestParam("papid") Integer papid){
        return idService.getItemdetail(papid);
    }
}
