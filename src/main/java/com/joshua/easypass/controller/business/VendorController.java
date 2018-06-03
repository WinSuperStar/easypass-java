package com.joshua.easypass.controller.business;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joshua.easypass.encap.DataTableResult;
import com.joshua.easypass.encap.DateTableParameter;
import com.joshua.easypass.entity.Vendor;
import com.joshua.easypass.service.VendorService;
import com.joshua.easypass.util.DateUtil;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class VendorController {
    public final static Logger logger = LoggerFactory.getLogger(VendorController.class);
    @Autowired
    private VendorService vdrService;

    @PostMapping(value = "/smtVdr")
    public void smtVdr(@RequestParam("vdrid") Integer vdrid){
        vdrService.smtVdr(vdrid);
    }

    @PostMapping(value = "/delVdr")
    public void delVdr(@RequestParam("vdrid") Integer vdrid){
        vdrService.delVdr(vdrid);
    }

    @GetMapping(value = "/getAllVdrs")
    public Vendor[] getAllVdrs() {
        return vdrService.getAllVdrs();
    }

    @PostMapping(value = "/createVdr")
    public Integer createVdr(@RequestParam("creator") String creator) {
        return vdrService.createVdr(creator);
    }

    @PostMapping(value = "/getVdr")
    public Vendor getVdr(@RequestParam("vdrid") Integer vdrid) {
        return vdrService.getVdr(vdrid);
    }

    @PostMapping(value = "/getVdrs")
    public DataTableResult<Vendor> getVdrs(@RequestParam("vdraddr1") String vdraddr1,
                            @RequestParam("vdraddr2") String vdraddr2,
                            @RequestParam("vdraddr3") String vdraddr3,
                            @RequestParam("vdrplate1") String vdrplate1,
                            @RequestParam("vdrplate2") String vdrplate2,
                            @RequestParam("contact") String contact,
                            @RequestParam("contactphone") String contactphone,
                            @RequestParam("firstdate") String firstdate,
                            @RequestParam("state") String state,
                            @RequestParam("itemlist") String itemlist,
                            DateTableParameter dateTableParameter
    ) {

    	
    	DataTableResult<Vendor>  dataTableResult = new DataTableResult<Vendor>();
    	Page<Vendor> dbPageData  = null;
    	dbPageData = vdrService.queryVdrPage(vdraddr1, vdraddr2, vdraddr3, vdrplate1, vdrplate2, contact, contactphone, firstdate, state, itemlist,dateTableParameter.currentPageIndex(), dateTableParameter.getLength());
    	dataTableResult.setDraw(dateTableParameter.getDraw());
    	dataTableResult.setData(dbPageData.getContent());
    	dataTableResult.setRecordsFiltered(dbPageData.getTotalElements());
    	dataTableResult.setRecordsTotal(dbPageData.getTotalElements());
        return dataTableResult;
    }

    @PostMapping(value = "/saveVdr")
    public void saveVdr(
            @RequestParam("vendor") String vendor
    ) {
        JSONObject jasonV = JSONObject.fromObject(vendor);
        logger.info("转成的jason对象为：" + jasonV);
        Vendor v = (Vendor) JSONObject.toBean(jasonV, Vendor.class);
        v.setItemTidangCompletedate("".equals(jasonV.get("itemTidangCompletedate"))?DateUtil.autoComDate():DateUtil.StrToDate(jasonV.get("itemTidangCompletedate")+""));
        v.setItemGuohuCompletedate("".equals(jasonV.get("itemGuohuCompletedate"))?DateUtil.autoComDate():DateUtil.StrToDate(jasonV.get("itemGuohuCompletedate")+""));
        v.setItemShangpaiCompletedate("".equals(jasonV.get("itemShangpaiCompletedate"))?DateUtil.autoComDate():DateUtil.StrToDate(jasonV.get("itemShangpaiCompletedate")+""));
        v.setItemWeizhangCompletedate("".equals(jasonV.get("itemWeizhangCompletedate"))?DateUtil.autoComDate():DateUtil.StrToDate(jasonV.get("itemWeizhangCompletedate")+""));
        v.setItemDiyaCompletedate("".equals(jasonV.get("itemDiyaCompletedate"))?DateUtil.autoComDate():DateUtil.StrToDate(jasonV.get("itemDiyaCompletedate")+""));
        v.setItemJiechudiyaCompletedate("".equals(jasonV.get("itemJiechudiyaCompletedate"))?DateUtil.autoComDate():DateUtil.StrToDate(jasonV.get("itemJiechudiyaCompletedate")+""));
        v.setItemWeituoCompletedate("".equals(jasonV.get("itemWeituoCompletedate"))?DateUtil.autoComDate():DateUtil.StrToDate(jasonV.get("itemWeituoCompletedate")+""));
        v.setItemNianjianCompletedate("".equals(jasonV.get("itemNianjianCompletedate"))?DateUtil.autoComDate():DateUtil.StrToDate(jasonV.get("itemNianjianCompletedate")+""));
        v.setItemBuhuanCompletedate("".equals(jasonV.get("itemBuhuanCompletedate"))?DateUtil.autoComDate():DateUtil.StrToDate(jasonV.get("itemBuhuanCompletedate")+""));
        v.setItemQitaCompletedate("".equals(jasonV.get("itemQitaCompletedate"))?DateUtil.autoComDate():DateUtil.StrToDate(jasonV.get("itemQitaCompletedate")+""));
        logger.info(v.toString());
        vdrService.saveVdr(v);
    }


<<<<<<< HEAD
//    @PostMapping(value = "/vendorPage")
//    public DataTableResult<Vendor> queryAccessLogPage(DateTableParameter dateTableParameter) {
//        DataTableResult<Vendor> dataTableResult = new DataTableResult<Vendor>();
//        Page<Vendor> dbPageData = vdrService.queryVendorPage(null, dateTableParameter.currentPageIndex(), dateTableParameter.getLength());
//        dataTableResult.setDraw(dateTableParameter.getDraw());
//        dataTableResult.setData(dbPageData.getContent());
//        dataTableResult.setRecordsFiltered(dbPageData.getTotalElements());
//        dataTableResult.setRecordsTotal(dbPageData.getTotalElements());
//        return dataTableResult;
//    }
=======
   
>>>>>>> 343a7d34b11a726407886fd0e4e48f855baae507
}
