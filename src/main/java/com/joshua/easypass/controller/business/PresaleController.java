package com.joshua.easypass.controller.business;

import com.joshua.easypass.entity.Presale;
import com.joshua.easypass.entity.Vendor;
import com.joshua.easypass.service.PresaleService;
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
public class PresaleController {
    public final static Logger logger = LoggerFactory.getLogger(VendorController.class);
    @Autowired
    private PresaleService pService;

    @PostMapping(value = "/savePresale")
    public void saveVdr(
            @RequestParam("presale") String presale){
        JSONObject jasonV = JSONObject.fromObject(presale);
        logger.info("转成的jason对象为：" + jasonV);

        Presale v = (Presale) JSONObject.toBean(jasonV, Presale.class);
        pService.savePresale(v);
    }

    @PostMapping(value = "/createPresale")
    public Integer createPresale(@RequestParam("creator") String creator) {
        return pService.createPresale(creator);
    }

    @PostMapping(value = "/getPresale")
    public Presale getPresale(@RequestParam("saleid") Integer saleid) {
        return pService.getPresale(saleid);
    }
}
