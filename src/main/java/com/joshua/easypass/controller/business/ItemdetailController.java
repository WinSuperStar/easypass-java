package com.joshua.easypass.controller.business;

import com.joshua.easypass.entity.Itemdetail;
import com.joshua.easypass.entity.Vendor;
import com.joshua.easypass.service.ItemdetailService;
import com.joshua.easypass.service.VendorService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class ItemdetailController {
    public final static Logger logger = LoggerFactory.getLogger(ItemdetailController.class);
    @Autowired
    private ItemdetailService idService;

    @PostMapping(value = "/createItemdetail")
    public Integer createVdr(@RequestParam("billid") Integer billid,
                             @RequestParam("billname") String billname,
                             @RequestParam("itemname") String itemname,
                             @RequestParam("creator") String creator,
                             @RequestParam("billtype") String billtype) {
        return idService.createItemdetail(billid, billname, itemname, creator, billtype);
    }

    @PostMapping(value="/saveItemdetail")
    public void saveItemdetail(@RequestParam("itemdetail") String itemdetail){
        JSONObject jasonV = JSONObject.fromObject(itemdetail);
        logger.info("转成的jason对象为：" + jasonV);

        Itemdetail i = (Itemdetail) JSONObject.toBean(jasonV, Itemdetail.class);
        idService.saveItemdetail(i);
    }

    @PostMapping(value = "/getItemdetail")
    public Itemdetail getVdr(@RequestParam("papid") Integer papid) {
        return idService.getItemdetail(papid);
    }
}
