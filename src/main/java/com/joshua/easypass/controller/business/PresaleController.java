package com.joshua.easypass.controller.business;

import com.joshua.easypass.entity.Presale;
import com.joshua.easypass.service.PresaleService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class PresaleController {
    public final static Logger logger = LoggerFactory.getLogger(VendorController.class);
    @Autowired
    private PresaleService pService;

    @PostMapping(value = "/delPresale")
    public void delPresale(@RequestParam("saleid") Integer saleid) {
        logger.info("接收到删除请求："+saleid);
        pService.delPresale(saleid);
    }


    @PostMapping(value = "/getPresales")
    public Presale[] getVdrs(@RequestParam("caraddr1") String caraddr1,
                             @RequestParam("caraddr2") String caraddr2,
                             @RequestParam("caraddr3") String caraddr3,
                             @RequestParam("carplate1") String carplate1,
                             @RequestParam("carplate2") String carplate2,
                             @RequestParam("cusmode") String cusmode,
                             @RequestParam("cusname") String cusname,
                             @RequestParam("state") String state,
                             @RequestParam("itemlist") String itemlist
    ) {

        return pService.getPresales(caraddr1, caraddr2, caraddr3, carplate1, carplate2, "全部".equals(cusmode) ? "" : cusmode, cusname, "全部".equals(state) ? "" : state, itemlist);

    }

    @PostMapping(value = "/savePresale")
    public void saveVdr(
            @RequestParam("presale") String presale) {
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
